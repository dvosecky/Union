package com.revature.dto;

import java.sql.Timestamp;

import com.revature.beans.Event;

public class EventDTO {
	private int eventid;
	private Timestamp time;
	private String name;
	private int accountID;
	
	
	
	public EventDTO(Event event, int accountID) {
		this.eventid=event.getId();
		this.time=event.getTime();
		this.name=event.getName();
		this.accountID = accountID;
	}
	public EventDTO(int eventid, Timestamp time, String name, int accountID) {
		super();
		this.eventid = eventid;
		this.time = time;
		this.name = name;
		this.accountID = accountID;
	}
	public EventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EventDTO [eventid=" + eventid + ", time=" + time + ", name=" + name + ", accountID=" + accountID + "]";
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
