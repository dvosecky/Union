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
@Table(name = "invitation")
public class Invitation {
	@Id
	@Column(name = "inv_id")
	@SequenceGenerator(sequenceName="inv_seq", name="inv_seq")
	@GeneratedValue(generator="inv_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account acc;
	@ManyToOne
	@JoinColumn(name = "ev_id")
	private Event ev;
	@Column(name = "priv_flag")
	private int privilegeFlag;
	@Column(name = "accept_flag")
	private int acceptFlag;
	public Account getacc() {
		return acc;
	}
	public void setacc(Account acc) {
		this.acc = acc;
	}
	public Event getev() {
		return ev;
	}
	public void setev(Event ev) {
		this.ev = ev;
	}
	public int getPrivilegeFlag() {
		return privilegeFlag;
	}
	public void setPrivilegeFlag(int privilegeFlag) {
		this.privilegeFlag = privilegeFlag;
	}
	public int getAcceptFlag() {
		return acceptFlag;
	}
	public void setAcceptFlag(int acceptFlag) {
		this.acceptFlag = acceptFlag;
	}
	public Invitation(int privilegeFlag, int acceptFlag) {
		super();
		this.privilegeFlag = privilegeFlag;
		this.acceptFlag = acceptFlag;
	}
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", privilegeFlag=" + privilegeFlag + ", acceptFlag=" + acceptFlag + "]";
	}
	
	
}
