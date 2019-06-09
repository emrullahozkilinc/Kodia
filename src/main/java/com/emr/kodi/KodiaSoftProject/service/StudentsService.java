package com.emr.kodi.KodiaSoftProject.service;

import java.util.List;

import com.emr.kodi.KodiaSoftProject.entity.Students;

public interface StudentsService {
	public List<Students> findAll();
	public Students findWithId(int id);
	public void save(Students student);
	public void delete(Students student);
}
