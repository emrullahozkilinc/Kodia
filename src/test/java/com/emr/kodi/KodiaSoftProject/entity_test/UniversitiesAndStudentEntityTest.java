package com.emr.kodi.KodiaSoftProject.entity_test;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.emr.kodi.KodiaSoftProject.dao.StudentsRepo;
import com.emr.kodi.KodiaSoftProject.dao.UniversitiesRepo;
import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.enums.UniversityType;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UniversitiesAndStudentEntityTest {
 
    @Autowired
    TestEntityManager entityManager;
 
    @Autowired
    private UniversitiesRepo universityRepo;
    
    @Autowired
    private StudentsRepo studentRepo;
 
    

    // write test cases here
    
    @Test
    public void whenTakeAllStudents_thenReturnAddedAllStudents() {
        // given
        Students alex = new Students("ali",new Date());
        Universities kbuuniversity=new Universities("KArabuk uni", "karabuk", "kbu.com", UniversityType.DEVLET, new Date());
        kbuuniversity.setApi_id(2);
        
        
        alex.setUniversity(kbuuniversity);
        kbuuniversity.add(alex);
        
        universityRepo.save(kbuuniversity);
        studentRepo.save(alex);
     
        
        
        // when
        List<Students> students = studentRepo.findAll();
     
        
        // then
        assertThat(students.get(0).getName())
          .isEqualTo(alex.getName());
        
    }
 
}
