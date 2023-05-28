package com.student.grid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.grid.model.Student;
import com.student.grid.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	StudentService service;
	
	@GetMapping("/{pageNo}/{pageSize}")
	public Page<Student> getAllStudent(@PathVariable(name = "pageNo") int pageNo ,@PathVariable(name = "pageSize") int pageSize)
	{
		return service.getAllStudent(pageNo,pageSize);
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<Student> getStudentById(@PathVariable int sid )
	{
		return new ResponseEntity<Student>(service.getStudentById(sid), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(service.saveStudent(student),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("{sid}")
	
	public ResponseEntity<String> deleteStudentById(@PathVariable int sid )
	{
		service.deleteStudentById(sid);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
	}
}
