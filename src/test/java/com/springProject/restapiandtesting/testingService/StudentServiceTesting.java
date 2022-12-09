package com.springProject.restapiandtesting.testingService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springProject.restapiandtesting.dao.StudentDAO;
import com.springProject.restapiandtesting.model.Student;
import com.springProject.restapiandtesting.service.StudentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTesting {
	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	@Mock
	private StudentDAO studentDAO;

	private Student s;

	private Student s1;

	@BeforeEach
	void init() {
		s = new Student();
		s.setId(01);
		s.setName("kalyan");
		s.setCourse("java");
		s.setAddress("hyd");

		s1 = new Student();
		s1.setId(02);
		s1.setName("pavan");
		s1.setCourse("node.js");
		s1.setAddress("hyd");

	}

	@Test
	@DisplayName("saving")
	void save() {
		when(studentDAO.save(any(Student.class))).thenReturn(s);
		Student ss = studentServiceImpl.save(s);
		assertNotNull(ss);
	}

	@Test
	@DisplayName("getAll ")
	void getAll() {
		List<Student> list = new ArrayList<>();
		list.add(s);
		list.add(s1);
		when(studentDAO.findAll()).thenReturn(list);
		List<Student> list1 = studentServiceImpl.getAll();

		assertNotNull(list1);
	}

	@Test
	@DisplayName("get By id")
	void getById() {
		when(studentDAO.findById(anyInt())).thenReturn(Optional.of(s));
		Student s3 = studentServiceImpl.getById(01);
		assertNotNull(s3);
	}


	@Test
	@DisplayName("delete by id")
	void deleteById() {

		Student s = new Student();
		s.setId(01);
		s.setName("kalyan");
		s.setCourse("java");
		s.setAddress("hyd");

		studentServiceImpl.deleteById(01);

		verify(studentDAO, times(1)).deleteById(s.getId());
	}

}
