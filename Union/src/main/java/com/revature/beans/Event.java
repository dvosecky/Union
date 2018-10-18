package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "lead_id")
	private Account lead;
	
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
	public Account getLead() {
		return lead;
	}
	public void setLead(Account lead) {
		this.lead = lead;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", lead=" + lead + "]";
	}
	public Event(int id, String name, Account lead) {
		super();
		this.id = id;
		this.name = name;
		this.lead = lead;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
}
