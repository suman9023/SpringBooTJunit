package com.springProject.restapiandtesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springProject.restapiandtesting.model.Student;
import com.springProject.restapiandtesting.service.StudentServiceImpl;

@RestController
public class StudentContoller
{
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/save")
	public void save(@RequestBody Student student)
	{
		System.out.println(student);
		studentServiceImpl.save(student);
	}
	
	
	@GetMapping("/getAll")
	public List<Student> getAll()
	{
		return studentServiceImpl.getAll();
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable int id)
	{
		return studentServiceImpl.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id)
	{
		studentServiceImpl.deleteById(id);
	}
	
}
