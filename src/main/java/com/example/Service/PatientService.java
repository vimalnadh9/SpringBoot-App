package com.example.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entity.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Object findAll(){
        return patientRepository.findAll();
    }

    public Patient findById(Long id){
        return patientRepository.findOne(id);
    }

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(Patient patient){
    	patientRepository.delete(patient);
    	return;
    }

	public Patient findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
    
}