package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="dep_id")
	@SequenceGenerator(sequenceName="department_seq" , name="department_seq")
	@GeneratedValue(generator="department_seq", strategy=GenerationType.SEQUENCE)
	private Integer dep_id;
	
	@Column(name="dname")
	private String dname;
	
	@OneToMany(mappedBy="dep")
	@Cascade(CascadeType.DELETE)
	private List<Account> members;
	
	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dname=" + dname + "]";
	}


	public List<Account> getMembers() {
		return members;
	}

	public void setMembers(List<Account> members) {
		this.members = members;
	}

	public Integer getDep_id() {
		return dep_id;
	}


	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}
}

