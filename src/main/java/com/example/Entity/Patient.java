package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;	
	
	public Patient(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile")
    private String PhoneNo;

 	
	public Patient (String name, String email, String PhoneNo) {
		this.name = name;
		this.email = email;
		this.PhoneNo = PhoneNo;		
	}
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	
}