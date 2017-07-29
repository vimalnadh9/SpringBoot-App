package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {
	public Patient findByEmail(String email);
	
	
}