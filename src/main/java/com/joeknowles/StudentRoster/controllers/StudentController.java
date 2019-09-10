package com.joeknowles.StudentRoster.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.joeknowles.StudentRoster.models.Contact;
import com.joeknowles.StudentRoster.models.ContactFormObject;
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
	public String createStudent(Model model, @Valid @ModelAttribute("student") Student s, BindingResult result) {
		service.createStudent(s);
		model.addAttribute("students", service.allStudents());
		return "/students/show.jsp";
	}
	
	@PostMapping("/contacts/new")
	public String newContact(Model model) {
		List<Student> needList = new ArrayList<>();
		for (Student s : service.allStudents()) {
			if (s.needsContact()) {
				needList.add(s);
			}
		}
		model.addAttribute("cfo", new ContactFormObject());
		model.addAttribute("students", needList);
		return "/students/createContact.jsp";
	}
	
	@GetMapping("/contacts/create")
	public String createContact(Model model, @Valid @ModelAttribute("cfo") ContactFormObject cfo, BindingResult result) {
		if (result.hasErrors() || cfo.getStudent_id() == -1) {
			model.addAttribute("failed", true);
			model.addAttribute("cfo", cfo);
			return "/students/createContact.jsp";
		}
		Optional<Student> oS = service.findStudentById(cfo.getStudent_id());
		if (oS.isPresent()) {
			Student s = oS.get();
			Contact c = cfo.getContact();
			c.setStudent(s);
			s.setContact(c);
			service.updateStudent(s);
		}
		model.addAttribute("students", service.allStudents());
		return "/students/show.jsp";
	}
	
	@PostMapping("/students")
	public String show(Model model) {
		model.addAttribute("students", service.allStudents());		
		return "/students/show.jsp";
	}
}












