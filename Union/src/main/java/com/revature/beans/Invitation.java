package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invitation")
public class Invitation {
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private List<Account> accs;
	@ManyToOne
	@JoinColumn(name = "ev_id")
	private List<Event> evs;
	@Column(name = "priv_flag")
	private int privilegeFlag;
	@Column(name = "accept_flag")
	private int acceptFlag;
	public List<Account> getAccs() {
		return accs;
	}
	public void setAccs(List<Account> accs) {
		this.accs = accs;
	}
	public List<Event> getEvs() {
		return evs;
	}
	public void setEvs(List<Event> evs) {
		this.evs = evs;
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
		return "Invitation [privilegeFlag=" + privilegeFlag + ", acceptFlag=" + acceptFlag + "]";
	}
	
	
}
