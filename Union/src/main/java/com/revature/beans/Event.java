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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "ev_id")
	@SequenceGenerator(sequenceName="MY_SEQ", name="javaName")
	@GeneratedValue(generator="javaName", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "ename")
	private String name;
	
	
	@ManyToMany
	@JoinTable(name="aerelation",
	joinColumns= @JoinColumn(name="ev_id"),
	inverseJoinColumns=@JoinColumn(name="acc_id"))
	private List<Account> accounts;
	
	@ManyToMany
	@JoinTable(name="invitation",
	joinColumns= @JoinColumn(name="ev_id"),
	inverseJoinColumns=@JoinColumn(name="acc_id"))
	private List<Account> invitation;

	
	
	public Event(Integer id, String name, List<Account> accounts, List<Account> invitation) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
		this.invitation = invitation;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", accounts=" + accounts + ", invitation=" + invitation + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getInvitation() {
		return invitation;
	}

	public void setInvitation(List<Account> invitation) {
		this.invitation = invitation;
	}
	
	
	
	

	
}
