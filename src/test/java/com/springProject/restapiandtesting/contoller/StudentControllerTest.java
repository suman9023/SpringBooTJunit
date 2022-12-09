package com.springProject.restapiandtesting.contoller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springProject.restapiandtesting.controller.StudentContoller;
import com.springProject.restapiandtesting.model.Student;
import com.springProject.restapiandtesting.service.StudentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest
{
	@InjectMocks
	private StudentContoller studentContoller;
	
	@Mock
	private StudentServiceImpl studentServiceImpl;
	
	
	private Student s;
	private Student s1;
	
	@Test
	@DisplayName("save method")
	void save()
	{
		s=new Student();
		s.setId(01);
		s.setName("karunya");
		s.setCourse("java");
		s.setAddress("hyd");
		
		s1=new Student();
		s1.setId(2);
		s1.setName("kapi");
		s1.setCourse("nodejs");
		s1.setAddress("bangalore");
		
		when(studentServiceImpl.save(any(Student.class))).thenReturn(s);
		
		studentContoller.save(s);
		
		assertNotNull(s);
				
	}

}
