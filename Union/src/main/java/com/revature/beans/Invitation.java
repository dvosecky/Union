package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invitation")
public class Invitation {

	@ManyToOne
	@JoinColumn( name="acc_id" )
	private Account acc_id;
	
	@ManyToOne
	@JoinColumn( name="ev_id" )
	private Event ev_id;

	
	
	public Invitation(Account acc_id, Event ev_id) {
		super();
		this.acc_id = acc_id;
		this.ev_id = ev_id;
	}

	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Invitation [acc_id=" + acc_id + ", ev_id=" + ev_id + "]";
	}

	public Account getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Account acc_id) {
		this.acc_id = acc_id;
	}

	public Event getEv_id() {
		return ev_id;
	}

	public void setEv_id(Event ev_id) {
		this.ev_id = ev_id;
	}

	
}
