package com.emr.kodi.KodiaSoftProject.serialization;

import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.fasterxml.jackson.databind.util.StdConverter;

public class UniversitySerializeInStudent extends StdConverter<Universities,String> {
	
	@Override
	public String convert(Universities value) {

		return value.getName();
	}

}
