package com.springrest.schoolsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.schoolsystem.model.StudentRegistration;
import com.springrest.schoolsystem.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<StudentRegistration> retrieveStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public void createStudents(@RequestBody StudentRegistration student) {
		studentRepository.save(student);
	}
	
	@GetMapping("/students/{email}/{password}")
	public boolean loginStudents(@PathVariable String email, @PathVariable String password){
		Optional<StudentRegistration> student= studentRepository.findByEmail(email);
		String value=student.get().getPassword();
		return value.equals(password);
	}
	
	@GetMapping("students/{email}")
	public Optional<StudentRegistration> retrieveStudent(@PathVariable String email) {
			return studentRepository.findByEmail(email);
		
	}
	
}
