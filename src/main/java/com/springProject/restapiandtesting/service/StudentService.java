package com.springProject.restapiandtesting.service;

import java.util.List;

import com.springProject.restapiandtesting.model.Student;

public interface StudentService
{
	
	List<Student> getAll();
	Student getById(int id);
	String deleteById(int id);
	Student save(Student student);

}
