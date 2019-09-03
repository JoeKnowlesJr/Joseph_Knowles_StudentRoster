package com.joeknowles.StudentRoster.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="students")
public class Student {

	private Long id;
	private String first_name;
	private String last_name;
	private int age;
	private Date studentCreated;
	private Date studentUpdated;
	private Contact contact;
	
	public Student() {}
	public Student(String f, String l, int a) {
		first_name = f;
		last_name = l;
		age = a;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
    @Column(name="first_name")
	public String getFirstName() { return first_name; }
	public void setFirstName(String first_name) { this.first_name = first_name; }
	
    @Column(name="last_name")
	public String getLastName() { return last_name; }
	public void setLastName(String last_name) { this.last_name = last_name; }
	
    @Column(name="age")
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	@PrePersist
	protected void onCreate() { this.studentCreated = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.studentUpdated = new Date(); }
	
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Contact getContact() { return contact; }
	public void setContact(Contact contact) { this.contact = contact; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "created")
	public Date getStudentCreated() { return studentCreated; }
	public void setStudentCreated(Date studentCreated) { this.studentCreated = studentCreated; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "updated")
	public Date getStudentUpdated() { return studentUpdated; }
	public void setStudentUpdated(Date studentUpdated) { this.studentUpdated = studentUpdated; }
	
	@Transient
	public String getName() { return String.format("%s %s", first_name, last_name); }
}
