package com.ktpo.kutuhanem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="passHash")
	private String passHash;
	
	@Column(name="isActive")
	private boolean isActive;

	public String getCode() {
		return code;
	}
	public Long getId() {
		return id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", code=" + code + ", email=" + email + ", pass=" + pass + ", passHash=" + passHash
				+ ", isActive=" + isActive + "]";
	}

	


}
