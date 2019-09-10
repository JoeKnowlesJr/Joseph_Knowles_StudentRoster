package com.joeknowles.StudentRoster.models;

public class ContactFormObject {
	private String address;
	private String city;
	private String state;
	private Long student_id;
	
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	public Long getStudent_id() { return student_id; }
	public void setStudent_id(Long student_id) { this.student_id = student_id; }
	
	public Contact getContact() {
		return new Contact(address, city, state);
	}
}
