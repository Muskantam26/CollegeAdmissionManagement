package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.CourseRepository;
import com.example.model.Course;

@Service
public class CourseService {

	@Autowired private CourseRepository courseRepository;
	public List<Course> getAllCourses() { return courseRepository.findAll(); }
	
}
