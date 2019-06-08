package com.emr.kodi.KodiaSoftProject.validation_test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
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
public class StudentsValidationTests {
	

    @Autowired
    TestEntityManager entityManager;
 
    @Autowired
    private UniversitiesRepo universityRepo;
    
    @Autowired
    private StudentsRepo studentRepo;
	
	private static Validator validator;
	
	@BeforeClass
	public static void setupValidatorInstance() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	 
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void whenSaveAnStudentsWithValidations_thenViolationsIsEmpty() throws ParseException {
		
		//given
		Students alex = new Students("ali",new Date());
        Universities kbuuniversity=new Universities("KArabusasdk uni", "karabuk", "kbu.com", UniversityType.DEVLET, new Date());
        kbuuniversity.setApi_id(4);
        
        
        alex.setUniversity(kbuuniversity);
        kbuuniversity.add(alex);
        
        
        //when
        universityRepo.save(kbuuniversity);
        studentRepo.save(alex);
	    
	    Set<ConstraintViolation<Students>> violations = validator.validate(alex);
	    
	  
	    //then
        assertTrue(violations.isEmpty());
	}
	
	
}
