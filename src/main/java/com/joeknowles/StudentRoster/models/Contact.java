package com.joeknowles.StudentRoster.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {

	private Long contact_id;
	private String address;
	private String city;
	private String state;
	private Student student;
	
	public Contact() {}
	public Contact(String a, String c, String s) {
		address = a;
		city = c;
		state = s;
	}
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="contact_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return contact_id; }
	public void setId(Long id) { this.contact_id = id; }
	
    @Column(name="address")
	public String getAddress() { return address; }
	public void setAddress(String adderss) { this.address = adderss; }
	
    @Column(name="city")
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
    @Column(name="state")
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
	public Student getStudent() { return student; }
	public void setStudent(Student student) { this.student = student; }
}