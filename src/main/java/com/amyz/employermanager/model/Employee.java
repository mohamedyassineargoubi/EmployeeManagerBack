package com.amyz.employermanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,updatable = false)
	private Long id;
	private String name;
	@NotEmpty(message = "Please fill your email address")
	private String email;
	private String jobTitle;
	private String phone;
	private String imageUrl;
	@Column(nullable = false,updatable = false)
	private String employeeCode;
	
	
	

}
