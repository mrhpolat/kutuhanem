package com.ktpo.kutuhanem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;


@Entity
@Table(name="allaccess")
public class AllAccess {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Nullable
	@Column(name="code")
	private String code;
	
	@Nullable
	@Column(name="description")
	private String descrition;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Writers [id=" + id + ", code=" + code + ", descrition=" + descrition + "]";
	}

	

}
