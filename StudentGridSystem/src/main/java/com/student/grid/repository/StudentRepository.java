package com.student.grid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.grid.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
