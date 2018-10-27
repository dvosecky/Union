package com.revature.dto;

import com.revature.beans.Account;

public class AccountDTO {

		private int id;
		private String username;
		private String password;
		private String firstname;
		private String lastname;
		private int dep;
		private int role;
		
		public AccountDTO( Account acc) {
		
			this.id = acc.getId();
			this.username=acc.getUsername();
			this.password=acc.getPassword();
			this.firstname=acc.getFirstname();
			this.lastname=acc.getLastname();
			this.dep=acc.getDep().getDep_id();
			this.role=acc.getRole();
		}
		
		public AccountDTO(int id, String username, String password, String firstname, String lastname, int dep,
				int role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.firstname = firstname;
			this.lastname = lastname;
			this.dep = dep;
			this.role = role;
		}
		@Override
		public String toString() {
			return "AccountDTO [id=" + id + ", username=" + username + ", password=" + password + ", firstname="
					+ firstname + ", lastname=" + lastname + ", dep=" + dep + ", role=" + role + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public int getDep() {
			return dep;
		}
		public void setDep(int dep) {
			this.dep = dep;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}


		
}
