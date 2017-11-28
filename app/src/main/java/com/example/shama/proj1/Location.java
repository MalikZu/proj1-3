package com.example.shama.proj1;

import com.example.shama.proj1.Campus;
import com.example.shama.proj1.Floor;

public class Location {

	private Campus campus;
	private Floor floor;
	private String room;
	
	
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
}
