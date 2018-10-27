package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name ="description")
	private String description;
	@Column(name ="location")
	private String location;
	@Column(name = "accept_flag")
	private Integer acceptFlag;
	
	@ManyToOne
	@JoinColumn(name = "lead_id")
	private Account lead;

	@OneToMany(mappedBy="ev")
	@Cascade(CascadeType.DELETE)
	List<Invitation> invites;
	
	public Integer getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(Integer acceptFlag) {
		this.acceptFlag = acceptFlag;
	}
	
	public Integer getId() {
		return id;
	}

	public List<Invitation> getInvites() {
		return invites;
	}

	public void setInvites(List<Invitation> invites) {
		this.invites = invites;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Account getLead() {
		return lead;
	}

	public void setLead(Account lead) {
		this.lead = lead;
	}



	@Override
	public String toString() {
		return "Event [id=" + id + ", time=" + time + ", name=" + name + ", description=" + description + ", location="
				+ location + ", acceptFlag=" + acceptFlag + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Event(Integer id, Timestamp time, String name, String description,
			String location, Account lead, Integer acceptFlag) {
		super();
		this.id = id;
		this.time = time;
		this.name = name;
		this.location=location;
		this.description=description;
		this.lead = lead;
		this.acceptFlag = acceptFlag;
	}

	public Event() {
		super();
	}
	
}