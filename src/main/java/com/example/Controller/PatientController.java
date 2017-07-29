package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Entity.Patient;
import com.example.Service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	  private PatientService patientService;
		
		@RequestMapping(value = "/patient", method = RequestMethod.GET)		
		@ResponseBody
		public Object index(){ 
			return patientService.findAll();
		}
	
	  @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	  
	  @ResponseBody
	  public String create(@RequestBody Patient patient) {
		  String userId = "";
	    try {	    
	      
	    	patientService.save(patient);
	   
	      userId = String.valueOf(patient.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  
	 
	  @RequestMapping("/delete/{id}")
	  @ResponseBody
	  public String delete(@PathVariable long id) {
	    try {
	    	Patient user = patientService.findById(id);
	    	patientService.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	    	Patient user = patientService.findByEmail(email);
	        userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  
	  @RequestMapping("/update/{id}")
	  @ResponseBody
	 
	  public String updateUser(@RequestBody Patient patient,@PathVariable Long id) {
		try {
	    	
	    	patient.setId(id);
	    	patientService.save(patient);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }

}