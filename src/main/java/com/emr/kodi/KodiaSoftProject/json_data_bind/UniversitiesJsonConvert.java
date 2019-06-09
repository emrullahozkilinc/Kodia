package com.emr.kodi.KodiaSoftProject.json_data_bind;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UniversitiesJsonConvert {

	public static List<Universities> convertToUniversities(){
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Universities>> typeReference = new TypeReference<List<Universities>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/universities.json");
		
		List<Universities> universities=null;
		
		try {
			universities = mapper.readValue(inputStream,typeReference);
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return universities;
	}
}
