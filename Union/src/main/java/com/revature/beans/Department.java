package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="dep_id")
	@SequenceGenerator(sequenceName="department_seq" , name="department_seq")
	@GeneratedValue(generator="department_seq", strategy=GenerationType.SEQUENCE)
	private Integer dep_id;
	
	@Column(name="dname")
	private String dname;

	@ManyToOne
	@JoinColumn(name="lead_id")
	private Account lead_id;

	public Integer getDep_id() {
		return dep_id;
	}

	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Account getLead_id() {
		return lead_id;
	}

	public void setLead_id(Account lead_id) {
		this.lead_id = lead_id;
	}

	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dname=" + dname + ", lead_id=" + lead_id + "]";
	}

	public Department(Integer dep_id, String dname, Account lead_id) {
		super();
		this.dep_id = dep_id;
		this.dname = dname;
		this.lead_id = lead_id;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

