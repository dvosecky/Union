package com.revature.beans;

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
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "acc_id")
	@SequenceGenerator(sequenceName="acc_seq", name="acc_seq")
	@GeneratedValue(generator="acc_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "uname")
	private String username;

	@Column(name = "pw")

	private String password;
	@Column(name = "fname")
	private String firstname;
	@Column(name = "lname")
	private String lastname;
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department dep;
	@Column(name = "role")
	private Integer role;
	
	@OneToMany(mappedBy="acc")
	@Cascade(CascadeType.DELETE)
	List<Invitation> invites;
	
	@OneToMany(mappedBy="lead")
	@Cascade(CascadeType.DELETE)
	List<Event> events;

	public Account(Integer id, String username, String password, String firstname, String lastname, Department dep,
			Integer role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dep = dep;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public Account() {
		super();
	}

	@Override
	public String toString() {

		return "Account [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dep=" + dep + "]";

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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Invitation> getInvites() {
		return invites;
	}

	public void setInvites(List<Invitation> invites) {
		this.invites = invites;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
