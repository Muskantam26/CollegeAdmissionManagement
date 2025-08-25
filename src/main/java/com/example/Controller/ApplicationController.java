package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.ApplicationService;
import com.example.model.Application;
import com.example.model.Student;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/application")
public class ApplicationController {

	@Autowired private ApplicationService applicationService;
	@PostMapping("/apply")
	public ResponseEntity<Application> apply(@RequestParam Long studentId,
	@RequestParam Long courseId,
	@RequestBody Student student) {
	return ResponseEntity.ok(applicationService.applyForCourse(studentId, courseId, student));
	}
	
	@PostMapping("/process")
	public ResponseEntity<String> process() {
	applicationService.approveOrRejectApplications();
	return ResponseEntity.ok("Processed.");
	}


	@GetMapping("/approved")
	public List<Application> approved() {
	return applicationService.getApproved();
	}
}
