package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="keyperson")
public class Keyperson {

	/*
	 *    role_id NUMBER(2),
    acc_id NUMBER(10),
     CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
     REFERENCES account (ev_id)
	 */
	
	@Id
	@Column(name="kp_id")
	@SequenceGenerator(sequenceName="kp_seq" , name="kp_seq")
	@GeneratedValue(generator="kp_seq", strategy=GenerationType.SEQUENCE)
	private Integer role_id;
	
	/*	@ManyToOne
		@JoinColumn(name="acc_id")
	 * private Account acc_id; 
	 */

}
