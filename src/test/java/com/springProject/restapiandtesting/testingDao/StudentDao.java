package com.springProject.restapiandtesting.testingDao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springProject.restapiandtesting.dao.StudentDAO;
import com.springProject.restapiandtesting.model.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDao
{
	@Autowired
	private StudentDAO studentDAO;
	
	private Student s;
	private Student s1;
	
	@BeforeEach
	public void init()
	{
		s=new Student();
		s.setName("kalyan");
		s.setCourse("java");
		s.setAddress("hyd");
		
		s1=new Student();
		s1.setName("pavan");
		s1.setCourse("node.js");
		s1.setAddress("hyd");
	}
	
	@Test
	@DisplayName("testing save method")
	void save()
	{
		Student ss= studentDAO.save(s);
		Student sss= studentDAO.save(s1);
		
		assertNotNull(sss);
		assertNotNull(ss);	
	}
	
	@Test
	@DisplayName("getAll details")
	void getAll()
	{
		Student ss= studentDAO.save(s);
		Student sss= studentDAO.save(s1);
		
		List<Student> list=new ArrayList<>();
		list.add(sss);
		list.add(ss);
		
		List<Student> student= studentDAO.findAll();
		
		assertNotNull(student);
	}

	@Test
	@DisplayName("get by name")
	void getById()
	{
		Student ss= studentDAO.save(s);
		
		assertThat("kalyan").isEqualTo(ss.getName());
	}
	
	
	@Test
	@DisplayName("delete by id")
	void deleteById()
	{
		Student ss= studentDAO.save(s);
		Student sss= studentDAO.save(s1);
		
		Student ssss= studentDAO.findById(ss.getId()).get();
		studentDAO.delete(ssss);
		
		
		assertEquals("kalyan", ssss.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
