package com.joeknowles.StudentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.StudentRoster.models.Contact;
import com.joeknowles.StudentRoster.models.Student;
import com.joeknowles.StudentRoster.repository.ContactRepository;
import com.joeknowles.StudentRoster.repository.StudentRepository;

@Service
public class ApiService {
	private StudentRepository sRepo;
	private ContactRepository cRepo;
	
	public ApiService(StudentRepository s, ContactRepository c) { sRepo = s; cRepo = c; }
	
	public List<Student> allStudents() { return sRepo.findAll(); }
	public void createStudent(Student s) { sRepo.save(s); }
	public void createContact(Contact c) { cRepo.save(c); }
	public void updateStudent(Student s) { sRepo.save(s); }
	public Optional<Student> findStudentById(Long id) { return sRepo.findById(id); }
}
