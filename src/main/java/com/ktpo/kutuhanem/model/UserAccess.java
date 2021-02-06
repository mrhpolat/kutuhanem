package com.ktpo.kutuhanem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="useraccess")
public class UserAccess {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="accessid")
	private int AccessId;
	@Column(name="userid")
	private int userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccessId() {
		return AccessId;
	}

	public void setAccessId(int accessId) {
		AccessId = accessId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccessId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccess other = (UserAccess) obj;
		if (AccessId != other.AccessId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAccess [id=" + id + ", AccessId=" + AccessId + ", userId=" + userId + "]";
	}

}
