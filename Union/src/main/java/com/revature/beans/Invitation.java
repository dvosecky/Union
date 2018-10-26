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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account acc;
	@ManyToOne
	@JoinColumn(name = "ev_id")
	private Event ev;
	@Column(name = "priv_flag")
	private Integer privilegeFlag;
	@Column(name = "accept_flag")
	private Integer acceptFlag;
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public Event getEv() {
		return ev;
	}
	public void setEv(Event ev) {
		this.ev = ev;
	}
	public Integer getPrivilegeFlag() {
		return privilegeFlag;
	}
	public void setPrivilegeFlag(Integer privilegeFlag) {
		this.privilegeFlag = privilegeFlag;
	}
	public Integer getAcceptFlag() {
		return acceptFlag;
	}
	public void setAcceptFlag(Integer acceptFlag) {
		this.acceptFlag = acceptFlag;
	}
	public Invitation(Integer id, Integer privilegeFlag, Integer acceptFlag) {
		super();
		this.id = id;
		this.privilegeFlag = privilegeFlag;
		this.acceptFlag = acceptFlag;
	}
	public Invitation(Integer id, Account acc, Event ev, Integer privilegeFlag, Integer acceptFlag) {
		super();
		this.id = id;
		this.acc = acc;
		this.ev = ev;
		this.privilegeFlag = privilegeFlag;
		this.acceptFlag = acceptFlag;
	}
	public Invitation() {
		super();
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", privilegeFlag=" + privilegeFlag + ", acceptFlag=" + acceptFlag + "]";
	}
	
	
}