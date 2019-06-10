package com.emr.kodi.KodiaSoftProject.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.emr.kodi.KodiaSoftProject.dao.StudentsRepo;
import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.service.StudentsService;
import com.emr.kodi.KodiaSoftProject.service.StudentsServiceImpl;

@RunWith(SpringRunner.class)
public class StudentUniversityTest {
 
    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
  
        @Bean
        public StudentsService studentService() {
            return new StudentsServiceImpl();
        }
    }
 
    @Autowired
    private StudentsService studentService;
 
    @MockBean
    private StudentsRepo studentRepository;
 
    // write test cases here
    
    
    @Before
    public void setUp() {
        Students alex = new Students();
        alex.setName("alex");
        
        Mockito.when(studentRepository.getOne(1))
          .thenReturn(alex);
    }
    
    
    @Test
    public void whenValidId_thenEmployeeShouldBeFound() {
        String name = "alex";
        Students found = studentService.findWithId(1);
      
         assertThat(found.getName())
          .isEqualTo(name);
     }
}
