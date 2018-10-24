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
@Table(name="keyperson")
public class Keyperson {

	
	@Id
	@Column(name="kp_id")
	@SequenceGenerator(sequenceName="kp_seq" , name="kp_seq")
	@GeneratedValue(generator="kp_seq", strategy=GenerationType.SEQUENCE)
	private Integer role_id;
	
	@ManyToOne
	@JoinColumn(name="acc_id")
	private Account acc;

	public Keyperson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Keyperson(Integer role_id) {
		super();
		this.role_id = role_id;
	}
	
	public Keyperson(Integer role_id, Account acc) {
		super();
		this.role_id = role_id;
		this.acc = acc;
	}

	@Override
	public String toString() {
		return "Keyperson [role_id=" + role_id + "]";
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}	

}
