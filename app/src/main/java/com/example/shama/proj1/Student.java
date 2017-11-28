package com.example.shama.proj1;

import java.util.ArrayList;

public class Student extends Person {

	private Campus campus;
	private ArrayList<Violation> violations;
	
	
	
	
	
	
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public ArrayList<Violation> getViolations() {
		return violations;
	}
	public void setViolations(ArrayList<Violation> violations) {
		this.violations = violations;
	}
}
