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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.emr.kodi.KodiaSoftProject.enums.UniversityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@ApiModel(description = "Entity for Students")
@Entity
@Table(name="universitiess")
@JsonIgnoreProperties(value= {"created_at","updated_at","hibernateLazyInitializer"})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Getter
@Setter
@NoArgsConstructor
public class Universities{

	@ApiModelProperty(value = "University id (autoincrement)")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int api_id;

	@ApiModelProperty(value = "University name", required = true)
	private String name;

	@ApiModelProperty(value = "City of university", required = true)
	private String city;

	@ApiModelProperty(value = "University webpage", required = true)
	private String web_page;

	@ApiModelProperty(value = "University type", example = "Devlet, Vakıf")
	@Enumerated(EnumType.STRING)
	private UniversityType type;

	@ApiModelProperty(value = "Date when university founded", example = "2020")
	@JsonFormat(pattern = "yyyy")
	private Date founded_at;

	@ApiModelProperty(value = "Time when university was created (auto generated)", example = "2020-01-01")
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_at;

	@ApiModelProperty(value = "Time when university updated (auto generated)", example = "2020-01-01")
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;


	@ApiModelProperty(value = "Students in this university.")
	@OneToMany(mappedBy="university")
	private List<Students> students;

	public Universities(String name, String city, String web_page, UniversityType type, Date founded_at) {
		super();
		this.name = name;
		this.city = city;
		this.web_page = web_page;
		this.type = type;
		this.founded_at = founded_at;
	}

	// Student nesnesinin listeye eklenmesi.
	public void add(Students student) {
		if (students==null)
			students=new LinkedList<>();
		students.add(student);
	}

	@Override
	public String toString() {
		return "Universities [id=" + id + ", api_id=" + api_id + ", name=" + name + ", city=" + city + ", web_page="
				+ web_page + ", type=" + type + ", founded_at=" + founded_at + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
}
