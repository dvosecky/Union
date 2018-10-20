package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aerelation")
public class Aerelation {

	@ManyToOne
	@JoinColumn(name="lead_id")
	private Account lead_id;
	
	@ManyToOne
	@JoinColumn(name="ev_id")
	private Event ev_id;

	
	
	
	@Override
	public String toString() {
		return "Aerelation [lead_id=" + lead_id + ", ev_id=" + ev_id + "]";
	}

	public Aerelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aerelation(Account lead_id, Event ev_id) {
		super();
		this.lead_id = lead_id;
		this.ev_id = ev_id;
	}

	public Account getLead_id() {
		return lead_id;
	}

	public void setLead_id(Account lead_id) {
		this.lead_id = lead_id;
	}

	public Event getEv_id() {
		return ev_id;
	}

	public void setEv_id(Event ev_id) {
		this.ev_id = ev_id;
	}
	
	
	
	
	
	
	
}
