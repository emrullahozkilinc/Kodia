package com.emr.kodi.KodiaSoftProject.service;

import java.util.List;

import com.emr.kodi.KodiaSoftProject.entity.Universities;


public interface UniversitiesService {
	public List<Universities> findAll();
	public Universities findWithId(int id);
	public void save(Universities university);
	public void delete(Universities university);
}
