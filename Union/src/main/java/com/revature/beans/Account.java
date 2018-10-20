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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "acc_id")
	@SequenceGenerator(sequenceName="acc_seq", name="acc_seq")
	@GeneratedValue(generator="acc_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "uname")
	private String username;
	@Column(name = "fname")
	private String firstname;
	@Column(name = "lname")
	private String lastname;
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department dep;
	
	@ManyToMany
	@JoinTable(name="adrelation" ,
				joinColumns= @JoinColumn(name="acc_id"),
				inverseJoinColumns=@JoinColumn(name="dep_id"))
	private List<Department> departments;
	
	@ManyToMany
	@JoinTable(name="aerelation",
				joinColumns= @JoinColumn(name="acc_id"),
				inverseJoinColumns=@JoinColumn(name="ev_id"))
	private List<Event> events;
	
	@ManyToMany
	@JoinTable(name="invitation",
				joinColumns= @JoinColumn(name="acc_id"),
				inverseJoinColumns=@JoinColumn(name="ev_id"))
	private List<Event> invitations;

	
	
	
	public Account(Integer id, String username, String firstname, String lastname, Department dep,
			List<Department> departments, List<Event> events, List<Event> invitations) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dep = dep;
		this.departments = departments;
		this.events = events;
		this.invitations = invitations;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dep=" + dep + ", departments=" + departments + ", events=" + events + ", invitations="
				+ invitations + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Event> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Event> invitations) {
		this.invitations = invitations;
	}
	
	
	
}
