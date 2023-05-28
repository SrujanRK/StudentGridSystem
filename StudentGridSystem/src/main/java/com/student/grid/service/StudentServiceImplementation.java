package com.student.grid.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.grid.exception.ResourceNotFoundException;
import com.student.grid.model.Student;
import com.student.grid.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	StudentRepository repository;
	@Override
	public Student getStudentById(int sid) {
		return repository.findById(sid).orElseThrow(()->
		new ResourceNotFoundException("Student", "Student Id", sid));
		
	}

	@Override
	public Page<Student> getAllStudent(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return this.repository.findAll(pageable);
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "Student Id", id));
		
		repository.deleteById(id);
		
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

}
