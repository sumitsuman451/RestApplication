package com.springrest.schoolsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.schoolsystem.model.StudentRegistration;

public interface StudentRepository extends JpaRepository<StudentRegistration, Integer>{

	Optional<StudentRegistration> findByEmail(String email);


}
