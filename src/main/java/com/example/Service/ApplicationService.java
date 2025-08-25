package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.ApplicationRepository;
import com.example.Repository.CourseRepository;
import com.example.model.Application;
import com.example.model.Course;
import com.example.model.Student;

@Service
public class ApplicationService {
	
	@Autowired private ApplicationRepository appRepo;
	@Autowired private CourseRepository courseRepo;


	public Application applyForCourse(Long studentId, Long courseId, Student student) {
	Course course = courseRepo.findById(courseId).orElseThrow();
	Application app = new Application();
	app.setStudent(student);
	app.setCourse(course);
	app.setStatus("Pending");
	return appRepo.save(app);
	}
	public void approveOrRejectApplications() {
		List<Application> apps = appRepo.findByStatus("Pending");
		for (Application app : apps) {
		if (app.getStudent().getMarks() >= app.getCourse().getCutOff()) {
		app.setStatus("Approved");
		} else {
		app.setStatus("Rejected");
		}
		appRepo.save(app);
		}
		}


		public List<Application> getApproved() {
		return appRepo.findByStatus("Approved");
		}
	

}
