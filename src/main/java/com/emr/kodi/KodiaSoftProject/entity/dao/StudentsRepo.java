package com.emr.kodi.KodiaSoftProject.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;

/*
 * Entity sınıfların tablolarla eşleşmesi için gerekli repo interface.
 */
@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer>{
	
}
