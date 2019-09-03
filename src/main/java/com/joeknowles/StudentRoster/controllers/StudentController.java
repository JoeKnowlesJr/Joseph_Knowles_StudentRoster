package com.joeknowles.StudentRoster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeknowles.StudentRoster.models.Contact;
import com.joeknowles.StudentRoster.models.Student;
import com.joeknowles.StudentRoster.services.ApiService;

@Controller
public class StudentController {
	private ApiService service;
	
	public StudentController(ApiService s) {
		service = s;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@PostMapping("/students/new")
	public String newStudent(Model model) {
		model.addAttribute("student", new Student());		
		return "/students/createStudent.jsp";
	}
	
	@GetMapping("/students/create")
	public String createStudent(Model model, @ModelAttribute("student") Student s) {
		service.createStudent(s);
		model.addAttribute("students", service.allStudents());
		return "/students/show.jsp";
	}
	
	@PostMapping("/contacts/new")
	public String newContact(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("students", service.allStudents());
		return "/students/createContact.jsp";
	}
	
	@GetMapping("/contacts/create")
	public String createContact(Model model, @ModelAttribute("contact") Contact contact) {
		service.createContact(contact);
		model.addAttribute("students", service.allStudents());
		return "/students/show.jsp";
	}
	
	@PostMapping("/students")
	public String show(Model model) {
		model.addAttribute("students", service.allStudents());		
		return "/students/show.jsp";
	}
}












