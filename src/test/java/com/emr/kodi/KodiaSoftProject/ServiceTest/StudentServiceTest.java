package com.emr.kodi.KodiaSoftProject.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emr.kodi.KodiaSoftProject.dao.StudentsRepo;
import com.emr.kodi.KodiaSoftProject.dao.UniversitiesRepo;
import com.emr.kodi.KodiaSoftProject.entity.Students;
import com.emr.kodi.KodiaSoftProject.entity.Universities;
import com.emr.kodi.KodiaSoftProject.enums.UniversityType;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class StudentServiceTest {
 
    @Autowired
    TestEntityManager entityManager;
 
    @Autowired
    private UniversitiesRepo universityRepo;
    
    @Autowired
    private StudentsRepo studentRepo;
 
    

    // write test cases here
    
    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED) 
    public void whenStudentUpdate_thenReturnUpdatedStudent() {
        // given
        Students alex = new Students("ali",new Date());
        Universities kbuuniversity=new Universities("KasdArabuasck uni", "karabuk", "kbu.com", UniversityType.DEVLET, new Date());
        kbuuniversity.setApi_id(9);
        
        
        alex.setUniversity(kbuuniversity);
        kbuuniversity.add(alex);
        
        universityRepo.save(kbuuniversity);
        studentRepo.save(alex);
     
        alex.setName("changed");
        studentRepo.save(alex);
        
        // when
        Optional<Students> students=studentRepo.findById(alex.getId());
        
        // then
        assertThat(students.get().getName())
          .isEqualTo(alex.getName());
        
    }
}
