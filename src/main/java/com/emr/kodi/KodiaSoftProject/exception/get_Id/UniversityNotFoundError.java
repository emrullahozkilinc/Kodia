package com.emr.kodi.KodiaSoftProject.exception.get_Id;

public class UniversityNotFoundError {

	String status;
	String message;
	
	public UniversityNotFoundError() {
	}

	public UniversityNotFoundError(String status, String message) {
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
