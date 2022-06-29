package com.emr.kodi.KodiaSoftProject.rest;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emr.kodi.KodiaSoftProject.dto.AllUniversitiesDto;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundError;
import com.emr.kodi.KodiaSoftProject.exception.get_Id.UniversityNotFoundException;
import com.emr.kodi.KodiaSoftProject.service.UniversitiesService;

@Api(value = "Operations pertaining to Universities")
@RestController
@RequestMapping("/universities")
public class UniversityREST {
	
	UniversitiesService universitiesService;
	
	ModelMapper modelMapper;

	@Autowired
	public UniversityREST(UniversitiesService universitiesService, ModelMapper modelMapper) {
		this.universitiesService = universitiesService;
		this.modelMapper = modelMapper;
	}

	@ApiOperation(value = "Get all Universities")
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
	public List<AllUniversitiesDto> getAllUniversities() {
		List<Universities> list=universitiesService.findAll();
		
		List<AllUniversitiesDto> convertedList=new LinkedList<>();

		for (Universities universities : list) {
			convertedList.add(modelMapper.map(universities, AllUniversitiesDto.class));
		}
        
		return convertedList;
	}
	
	//silinecek
	@GetMapping("/age")
	ResponseEntity<String> age() {
	  
	    return new ResponseEntity<>("Your age is ",HttpStatus.BAD_REQUEST);
	}
	
	
	@ApiOperation(value = "Get University with id")
	@GetMapping("/{id}")
	public Universities getUniversity(@PathVariable(name="id",required=true) int id) {
		
		Universities university=universitiesService.findWithId(id);
		
		try {
			university.getName();
		} catch (EntityNotFoundException e) {
			throw new UniversityNotFoundException("Üniversite bulunamadı.");
		}
		
		
		return university;
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<UniversityNotFoundError> handleException(UniversityNotFoundException exc) {
		
		UniversityNotFoundError error = new UniversityNotFoundError();
		
		error.setStatus("error");
		error.setMessage(exc.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	
}
