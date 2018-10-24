package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "ev_id")
	@SequenceGenerator(sequenceName="MY_SEQ", name="javaName")
	@GeneratedValue(generator="javaName", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "etime")
	private Timestamp time;
	@Column(name = "ename")
	private String name;
	
	@ManyToOne
	@Cascade({CascadeType.ALL})
	@JoinTable(name="aerelation",
	joinColumns= @JoinColumn(name="ev_id"),
	inverseJoinColumns=@JoinColumn(name="lead_id"))
	private Account account;

	@OneToMany(mappedBy="ev")
	@Cascade({CascadeType.ALL})
	List<Invitation> invites;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Invitation> getInvites() {
		return invites;
	}

	public void setInvites(List<Invitation> invites) {
		this.invites = invites;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", time=" + time + ", name=" + name + "]";
	}

	public Event(Integer id, Timestamp time, String name, Account account) {
		super();
		this.id = id;
		this.time = time;
		this.name = name;
		this.account = account;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
