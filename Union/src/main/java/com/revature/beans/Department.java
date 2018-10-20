package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer dep_id, String dname) {
		super();
		this.dep_id = dep_id;
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dname=" + dname + "]";
	}

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

	
}

