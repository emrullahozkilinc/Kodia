package com.emr.kodi.KodiaSoftProject.dto_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.emr.kodi.KodiaSoftProject.dto.AllUniversitiesDto;
import com.emr.kodi.KodiaSoftProject.entity.Universities;

public class AllUniversitiesDtoTest {

    private ModelMapper modelMapper = new ModelMapper();
    
    @Test
    public void whenConvertuniversityEntityTouniversityDto_thenCorrect() {
        Universities university= new Universities();
    
        university.setName("ankata");
        university.setId(2);
        
        AllUniversitiesDto universityDto=modelMapper.map(university,AllUniversitiesDto.class);
        
        assertEquals(university.getId(), universityDto.getId());
        assertEquals(university.getName(), universityDto.getName());
    }
}
