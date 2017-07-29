package com.example.DAO;

import com.example.Entity.Patient;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAO {

	private static Map<Integer, Patient> patients;
	
}