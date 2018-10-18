package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "acc_id")
	@SequenceGenerator(sequenceName="acc_seq", name="accName")
	@GeneratedValue(generator="javaName", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "uname")
	private String username;
	@Column(name = "fname")
	private String firstname;
	@Column(name = "lname")
	private String lastname;
//	private Department dep;
}
