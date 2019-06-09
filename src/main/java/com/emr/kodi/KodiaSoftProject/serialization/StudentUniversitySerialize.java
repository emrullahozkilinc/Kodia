package com.emr.kodi.KodiaSoftProject.serialization;

import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.json_data_bind.UniversitiesJsonConvert;
import com.fasterxml.jackson.databind.util.StdConverter;

public class StudentUniversitySerialize extends StdConverter<Integer,Universities> {
	
	@Override
	public Universities convert(Integer value) {
		return UniversitiesJsonConvert.convertToUniversities().get(value);
	}
}
