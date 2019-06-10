package com.emr.kodi.KodiaSoftProject.rest;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emr.kodi.KodiaSoftProject.dto.AllStudentsDto;
import com.emr.kodi.KodiaSoftProject.dto.SingleStudentsDto;
import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.AddStudentErrors;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.AddStudentException;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.StudentNotFoundError;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.StudentNotFoundException;
import com.emr.kodi.KodiaSoftProject.service.StudentsService;
import com.emr.kodi.KodiaSoftProject.service.UniversitiesService;

@RestController
@RequestMapping("/students")
public class StudentREST {

	@Autowired
	StudentsService studentsService;
	
	@Autowired
	UniversitiesService universityService;

	@Autowired
	ModelMapper modelMapper;
	
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
	public List<AllStudentsDto> getAllStudents() {
		
		List<Students> list=studentsService.findAll();
		
		List<AllStudentsDto> convertedList=new LinkedList<>();
		
		
		for (int i = 0; i < list.size(); i++) {
			convertedList.add(modelMapper.map(list.get(i), AllStudentsDto.class));
			convertedList.get(i).setUniversity(list.get(i).getUniversity().getName());
		}
		
		return convertedList;
	}

	@PostMapping
	public void addStudent(@Valid @RequestBody Students student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.err.println(bindingResult.getErrorCount());
			for (FieldError error:bindingResult.getFieldErrors()) {
				throw new AddStudentException(error.getDefaultMessage());
			}
		}
		
		List<Universities> allUniversities=universityService.findAll();
		

		Universities universityToAdd=student.getUniversity();
		
		boolean isFind=false;
		
		for (Universities university : allUniversities) {
			if(universityToAdd.getId()==university.getApi_id()) {
				isFind=true;
				break;
			}
		}
		
		
		if(!isFind) {
			universityToAdd.setApi_id(student.getUniversity().getId());
			universityService.save(universityToAdd);
		}

		studentsService.save(student);
	}
	
	@GetMapping("/{id}")
	public SingleStudentsDto getStudent(@PathVariable(name="id",required=true) int id) {
		
		Students student=studentsService.findWithId(id);
		
		try {
			student.getName();
		} catch (EntityNotFoundException e) {
			throw new StudentNotFoundException(id+" numara kayıtlı öğrenci bulunamadı.");
		}
		
		modelMapper.map(student, SingleStudentsDto.class);
		
		return modelMapper.map(student, SingleStudentsDto.class);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentNotFoundError> handleException(StudentNotFoundException exc) {
		
		StudentNotFoundError error = new StudentNotFoundError();
		
		error.setStatus("error");
		error.setMessage(exc.getMessage());
		
		return new ResponseEntity<StudentNotFoundError>(error, HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler
	public ResponseEntity<AddStudentErrors> handleAddStudentException(AddStudentException exc) {
		
		AddStudentErrors error = new AddStudentErrors();
		
		error.setStatus("error");
		error.setMessage(exc.getMessage());
		
		return new ResponseEntity<AddStudentErrors>(error, HttpStatus.NOT_FOUND);
	 }
	
}
