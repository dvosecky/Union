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
	private Account acc_id; 
	 

}
