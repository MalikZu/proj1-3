package com.example.shama.proj1;

public class Person {

	private String id;
	private String dateOfBirth;
	private String name;
	private Gender gender;
	private String email;

	public Gender getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
}
