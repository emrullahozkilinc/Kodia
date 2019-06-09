package com.emr.kodi.KodiaSoftProject.serialization;

import java.sql.Date;

import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentSerialization {

	
	public String name;
	public Date started_at;
	public int university_id;
	public Universities university;
	
	
	
	@JsonCreator
	public StudentSerialization(
			@JsonProperty("name") String name,
			@JsonProperty("started_at") Date started_at,
			@JsonProperty("university") int university_id) {
		

		
		System.err.println(toString());
		
		this.name=name;
		this.started_at=started_at;
		this.university_id=university_id;
		
		System.out.println(toString());
		
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



	public int getUniversity_id() {
		return university_id;
	}



	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}



	public Universities getUniversity() {
		return university;
	}



	public void setUniversity(Universities university) {
		this.university = university;
	}



	@Override
	public String toString() {
		return "StudentSerialization [name=" + name + ", started_at=" + started_at + ", university_id=" + university_id;
	}
	
	
}
