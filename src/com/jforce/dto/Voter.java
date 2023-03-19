package com.jforce.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "VOTER_Registeration")
public class Voter {

	@Id
	private String username;
	private String password;
	private String email;
	private Integer phone;
	
	private Integer voted;
	
	
	public Integer getVoted() {
		return voted;
	}
	public void setVoted(Integer voted) {
		this.voted = voted;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Voter [username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}

	
}
