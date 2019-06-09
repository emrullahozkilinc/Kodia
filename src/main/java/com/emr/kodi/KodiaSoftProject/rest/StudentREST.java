package com.emr.kodi.KodiaSoftProject.rest;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emr.kodi.KodiaSoftProject.dto.AllStudentsDto;
import com.emr.kodi.KodiaSoftProject.dto.StudentDto;
import com.emr.kodi.KodiaSoftProject.dto.UniversityDto;
import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.AddStudentErrors;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.AddStudentException;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.StudentNotFoundError;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.StudentNotFoundException;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundError;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundException;
import com.emr.kodi.KodiaSoftProject.service.StudentsService;
import com.emr.kodi.KodiaSoftProject.service.UniversitiesService;

@RestController
@RequestMapping("/students")
public class StudentREST {

	@Autowired
	UniversitiesService universitiesService;

	@Autowired
	StudentsService studentsService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK, reason = "Başarıyla tüm üniversiteler  getirildi.")
	public AllStudentsDto getAllStudents() {
		return null;
	}

	@PostMapping
	public void addStudent(@Valid @RequestBody Students student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error:bindingResult.getFieldErrors()) {
				throw new AddStudentException(error.getDefaultMessage());
			}
		}
		studentsService.save(student);
	}
	
	@GetMapping("/{id}")
	public StudentDto getStudent(@PathVariable(name="id",required=true) int id) {
		
		Students student=null;
		student=studentsService.findWithId(id);
		
		try {
			student.getName();
		} catch (EntityNotFoundException e) {
			throw new StudentNotFoundException(id+" numara kayıtlı öğrenci bulunamadı.");
		}
		return null;
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentNotFoundError> handleException(UniversityNotFoundException exc) {
		
		StudentNotFoundError error = new StudentNotFoundError();
		
		error.setStatus("error");
		error.setMessage(exc.getMessage());
		
		return new ResponseEntity<StudentNotFoundError>(error, HttpStatus.NOT_FOUND);
	 }
	
}
