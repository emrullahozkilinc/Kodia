package com.emr.kodi.KodiaSoftProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.kodi.KodiaSoftProject.dao.UniversitiesRepo;
import com.emr.kodi.KodiaSoftProject.entity.Universities;

@Service
public class UniversitiesServiceImpl implements UniversitiesService {

	@Autowired
	UniversitiesRepo universitiesRepo;
	
	@Override
	public List<Universities> findAll() {
		return universitiesRepo.findAll();
	}

	@Override
	public Universities findWithId(int id) {
		return universitiesRepo.getOne(id);
	}

	@Override
	public void save(Universities university) {
		universitiesRepo.save(university);
	}

	@Override
	public void delete(Universities university) {
		universitiesRepo.delete(university);
	}

}
