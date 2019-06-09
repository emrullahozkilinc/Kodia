package com.emr.kodi.KodiaSoftProject.exception.get_Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

public class AddStudentErrors {
	String status;
	String message;
	
	@Autowired
	Errors errors;
	
	public AddStudentErrors() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AddStudentErrors(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
