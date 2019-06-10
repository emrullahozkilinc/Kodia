package com.emr.kodi.KodiaSoftProject.serialization;

import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializitionNestedObjectTest {
	@Test
	public void givenBidirectionRelation_whenUsingJsonIdentityInfo_thenCorrect()
	  throws JsonProcessingException {
	  
	    Universities university= new Universities();
	    Students student= new Students();
	    
	    student.setName("ali");
	    student.setCreated_at(new Date());
	    student.setUniversity(university);
	    
	    university.add(student);
	    
	    String result = new ObjectMapper().writeValueAsString(university);
	 
	    assertThat(result, containsString("ali"));
	    assertThat(result, containsString("university"));

	}
}
