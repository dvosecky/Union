package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinTable(name="adrelation",
	joinColumns= @JoinColumn(name="dep_id"),
	inverseJoinColumns= @JoinColumn(name="lead_id"))
	private Account account;


	
	
	public Department(Integer dep_id, String dname) {
		super();
		this.dep_id = dep_id;
		this.dname = dname;
	}


	public Department(Integer dep_id, String dname, Account account) {
		super();
		this.dep_id = dep_id;
		this.dname = dname;
		this.account = account;
	}


	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dname=" + dname+ "]";
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


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}

