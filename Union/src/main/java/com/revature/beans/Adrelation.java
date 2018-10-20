package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="adrelation")
public class Adrelation {

	@ManyToOne
	@JoinColumn(name="lead_id")
	private Account lead_id;
	
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Department dep_id;
	
	
	
	

	public Adrelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adrelation(Account lead_id, Department dep_id) {
		super();
		this.lead_id = lead_id;
		this.dep_id = dep_id;
	}

	@Override
	public String toString() {
		return "Adrelation [lead_id=" + lead_id + ", dep_id=" + dep_id + "]";
	}

	public Account getLead_id() {
		return lead_id;
	}

	public void setLead_id(Account lead_id) {
		this.lead_id = lead_id;
	}

	public Department getDep_id() {
		return dep_id;
	}

	public void setDep_id(Department dep_id) {
		this.dep_id = dep_id;
	}
	
	
	
	
}
