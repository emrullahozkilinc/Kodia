package com.emr.kodi.KodiaSoftProject.dto;

import java.util.Date;

public class AllStudentsDto {
	int id;
	String name;
	Date started_at;
	String university;
	
	
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
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getUniversity() {
		return university;
	}
	
}
