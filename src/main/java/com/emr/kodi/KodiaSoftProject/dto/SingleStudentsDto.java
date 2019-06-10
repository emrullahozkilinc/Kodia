package com.emr.kodi.KodiaSoftProject.dto;

import java.sql.Date;

public class SingleStudentsDto {
	int id;
	String name;
	Date started_at;
	UniversityDtoForSingleStudentsDto university;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStarted_at() {
		return started_at;
	}
	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}
	public UniversityDtoForSingleStudentsDto getUniversity() {
		return university;
	}
	public void setUniversity(UniversityDtoForSingleStudentsDto university) {
		this.university = university;
	}
	
	
}
