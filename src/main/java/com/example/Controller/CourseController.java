package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.CourseService;
import com.example.model.Course;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/courses")

public class CourseController {

	@Autowired private CourseService courseService;
	@GetMapping("/all")
	public List<Course> allCourses() {
	return courseService.getAllCourses();
	}
}
