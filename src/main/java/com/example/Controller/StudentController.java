package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.StudentService;
import com.example.model.Student;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<Student> register(@RequestBody Student student){
		
		return ResponseEntity.ok(studentService.registerStudent(student));
	}
	
}
