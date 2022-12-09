package com.springProject.restapiandtesting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springProject.restapiandtesting.dao.StudentDAO;
import com.springProject.restapiandtesting.model.Student;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> getAll()
	{
		return studentDAO.findAll();
	}

	@Override
	public Student getById(int id)
	{
		return studentDAO.findById(id).get();
	}

	@Override
	public String deleteById(int id)
	{
		studentDAO.deleteById(id);
		
		return "deleted sucessfully";
	}

	@Override
	public Student save(Student student)
	{
		return studentDAO.save(student);
	}
	

	

}
