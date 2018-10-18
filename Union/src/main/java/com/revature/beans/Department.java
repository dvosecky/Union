package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	/*
	@ManyToOne
	@JoinColumn(name="lead_id")
	private Account lead_id;
	
	*/
	
	
	
}

