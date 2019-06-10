package com.emr.kodi.KodiaSoftProject.exception.get_Id;

public class AddStudentErrors {
	String status;
	String message;
	
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
