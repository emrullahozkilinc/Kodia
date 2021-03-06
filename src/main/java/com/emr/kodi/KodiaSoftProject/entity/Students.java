package com.emr.kodi.KodiaSoftProject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.emr.kodi.KodiaSoftProject.serialization.StudentUniversitySerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/*
 * Students entity sınıfı.
 * 
 */


@Entity
@Table(name="students")
@JsonIgnoreProperties(value= {"created_at","updated_at"})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Students{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Öğrenci adı boş bırakılamaz.")
	private String name;
	
	//Üniversiteye başlangıç tarihi
	@NotNull(message="Tarih boş bırakılamaz.")
	@PastOrPresent
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date started_at;
	
	//Objenin değişkeni oluşturulması durumunda o anki zaman bu değişkene kaydedilir. 
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	
	//Objenin herhangi bir değişkeninin güncellenmesi durumunda o anki zaman bu değişkene kaydedilir.
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
	//Üniversitenin tutulduğu değişken. Tablodaki university_id ile eşleşir.
	@JsonDeserialize(converter = StudentUniversitySerialize.class)
	@ManyToOne
	@JoinColumn(name="university_id")
	private Universities university;
	
	
	public Students() {
		// TODO Auto-generated constructor stub
	}

	
	public Students(String name, Date started_at) {
		this.name = name;
		this.started_at = started_at;
	}
	
	
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Universities getUniversity() {
		return university;
	}

	public void setUniversity(Universities university) {
		this.university = university;
	}


	

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", started_at=" + started_at + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", university=" + university.getName() + "]";
	}
	
}
