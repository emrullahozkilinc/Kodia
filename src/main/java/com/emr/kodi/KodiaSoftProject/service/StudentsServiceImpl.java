package com.emr.kodi.KodiaSoftProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.kodi.KodiaSoftProject.dao.StudentsRepo;
import com.emr.kodi.KodiaSoftProject.entity.Students;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	StudentsRepo studentsRepo;
	
	@Override
	public List<Students> findAll() {
		return studentsRepo.findAll();
	}

	@Override
	public Students findWithId(int id) {
		return studentsRepo.getOne(id);
	}

	@Override
	public void save(Students student) {
		studentsRepo.save(student);
	}

	@Override
	public void delete(Students student) {
		studentsRepo.delete(student);
	}
}
