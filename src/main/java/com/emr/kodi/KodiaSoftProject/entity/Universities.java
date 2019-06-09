package com.emr.kodi.KodiaSoftProject.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.emr.kodi.KodiaSoftProject.enums.UniversityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Universities entity sınıfı.
 * 
 */
@Entity
@Table(name="universitiess")
@JsonIgnoreProperties(value= {"created_at","updated_at"},
		allowGetters=true)
public class Universities{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int api_id;
	
	private String name;
	private String city;
	private String web_page;
	
	//devlet ve vakıf üniversitesi şeklinde iki tip barındaran enum.
	@Enumerated(EnumType.STRING)
	private UniversityType type;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date founded_at;
	
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	
	
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
	
	//university parametresi Students sınıfındaki university adlı değişkeni işaret eder.
	@OneToMany(mappedBy="university")
	private List<Students> students;
	
	
	public Universities() {
		// TODO Auto-generated constructor stub
	}


	public Universities(String name, String city, String web_page, UniversityType type, Date founded_at) {
		super();
		this.name = name;
		this.city = city;
		this.web_page = web_page;
		this.type = type;
		this.founded_at = founded_at;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getApi_id() {
		return api_id;
	}


	public void setApi_id(int api_id) {
		this.api_id = api_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getWeb_page() {
		return web_page;
	}


	public void setWeb_page(String web_page) {
		this.web_page = web_page;
	}


	public UniversityType getType() {
		return type;
	}


	public void setType(UniversityType type) {
		this.type = type;
	}


	public Date getFounded_at() {
		return founded_at;
	}


	public void setFounded_at(Date founded_at) {
		this.founded_at = founded_at;
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
	
	// Student nesnesinin listeye eklenmesi.
	public void add(Students student) {
		if (students==null)
			students=new LinkedList<>();
		students.add(student);
	}
	
	public List<Students> getStudents() {
		return students;
	}


	@Override
	public String toString() {
		return "Universities [id=" + id + ", api_id=" + api_id + ", name=" + name + ", city=" + city + ", web_page="
				+ web_page + ", type=" + type + ", founded_at=" + founded_at + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	
	
}
