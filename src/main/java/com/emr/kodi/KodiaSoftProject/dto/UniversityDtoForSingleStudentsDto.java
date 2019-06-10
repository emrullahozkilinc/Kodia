package com.emr.kodi.KodiaSoftProject.dto;

import java.sql.Date;

import com.emr.kodi.KodiaSoftProject.enums.UniversityType;

public class UniversityDtoForSingleStudentsDto {

	int id;
	String name;
	Date founded_at;
	UniversityType type;
	
	
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
	public Date getFounded_at() {
		return founded_at;
	}
	public void setFounded_at(Date founded_at) {
		this.founded_at = founded_at;
	}
	public UniversityType getType() {
		return type;
	}
	public void setType(UniversityType type) {
		this.type = type;
	}
	
	
}
