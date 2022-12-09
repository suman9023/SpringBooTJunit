package com.springProject.restapiandtesting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springProject.restapiandtesting.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

}
