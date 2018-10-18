package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="invitation")
public class Invitation {
	
	/*
	 *     acc_id NUMBER(10),
    ev_id NUMBER(10),
    CONSTRAINT invitation_acc_fk FOREIGN KEY (acc_id)
    REFERENCES account (acc_id),
    CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
    REFERENCES account (ev_id)
	 */
	/*
	private Account acc_id;
	private Account ev_id;

	*/
}
