package com.revature.dto;

import com.revature.beans.Department;

public class DepartmentDTO {
	private int id;
	private String name;
	
	public DepartmentDTO() {
		super();
	}
	
	public DepartmentDTO(Department d) {
		id = d.getDep_id();
		name = d.getDname();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}
}
