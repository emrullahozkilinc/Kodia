package com.emr.kodi.KodiaSoftProject.rest;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emr.kodi.KodiaSoftProject.dto.AllStudentsDto;
import com.emr.kodi.KodiaSoftProject.dto.AllUniversitiesDto;
import com.emr.kodi.KodiaSoftProject.dto.UniversityDto;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundError;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundException;
import com.emr.kodi.KodiaSoftProject.service.StudentsService;
import com.emr.kodi.KodiaSoftProject.service.UniversitiesService;

@RestController
@RequestMapping("/universities")
public class UniversityREST {
	
	@Autowired
	UniversitiesService universitiesService;
	
	@Autowired
	StudentsService studentsService;
	
	@GetMapping
	@ResponseStatus(value=HttpStatus.OK,code=HttpStatus.OK,reason="Başarıyla tüm üniversiteler  getirildi.")
	public AllUniversitiesDto getAllUniversities() {
		return null;
	}
	
	
	@GetMapping("/{id}")
	public UniversityDto getUniversity(@PathVariable(name="id",required=true) int id) {
		
		Universities university=null;
		university=universitiesService.findWithId(id);
		
		try {
			university.getName();
		} catch (EntityNotFoundException e) {
			throw new UniversityNotFoundException(id+" numara kayıtlı üniversite bulunamadı.");
		}
		
		
		return null;
		
	}
	
	@ExceptionHandler
	public ResponseEntity<UniversityNotFoundError> handleException(UniversityNotFoundException exc) {
		
		UniversityNotFoundError error = new UniversityNotFoundError();
		
		error.setStatus("error");
		error.setMessage(exc.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	
}
