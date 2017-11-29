package com.example.shama.proj1;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class Student extends Person {

	private Campus campus;
	private ArrayList<Violation> violations;

	private DatabaseReference mDatabase;

	public Student(String id){
		this();
		// Get a reference to our posts
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("users"+id);

		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				Student student = dataSnapshot.getValue(Student.class);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				System.out.println(databaseError.getMessage());
			}
		});


	}
	public Student() {
		mDatabase = FirebaseDatabase.getInstance().getReference();
	}

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

	public void addViolation(Violation violation){
		this.violations.add(violation);
	}

	public void updateFirebase(){
		DatabaseReference newUser = mDatabase.child("users").child(this.getId()).push();

		newUser.setValue(this);
	}
}
