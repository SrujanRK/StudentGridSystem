package com.student.grid.service;


import org.springframework.data.domain.Page;

import com.student.grid.model.Student;

public interface StudentService {
	Student getStudentById(int sid);
	void deleteStudentById(int id);
	Student saveStudent(Student student);
	Page<Student> getAllStudent(int pageNo, int pageSize);
	
}
