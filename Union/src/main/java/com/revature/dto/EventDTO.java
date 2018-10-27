package com.revature.dto;

import java.sql.Timestamp;

import com.revature.beans.Event;

public class EventDTO {
	private int eventid;
	private Timestamp time;
	private String name;
	private String description;
	private String location;
	private int accountID;
	
	
	


	
	public EventDTO( Event event,int accountID) {
		this.eventid=event.getId();
		this.time=event.getTime();
		this.name=event.getName();
		this.description=event.getDescription();
		this.location=event.getLocation();
		
		this.accountID = accountID;
	}
	public EventDTO(int eventid, Timestamp time, String name, String description, String location, int accountID) {
		super();
		this.eventid = eventid;
		this.time = time;
		this.name = name;
		this.description = description;
		this.location = location;
		this.accountID = accountID;
	}
	@Override
	public String toString() {
		return "EventDTO [eventid=" + eventid + ", time=" + time + ", name=" + name + ", description=" + description
				+ ", location=" + location + ", accountID=" + accountID + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
	
}
