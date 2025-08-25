package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String courseName;
	private double cutOff;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCutOff() {
		return cutOff;
	}
	public void setCutOff(double cutOff) {
		this.cutOff = cutOff;
	}
	
	
}
