package com.emr.kodi.KodiaSoftProject.dto;

public class AllUniversitiesDto {

	int id;
	String name;
	
	
	public AllUniversitiesDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AllUniversitiesDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
