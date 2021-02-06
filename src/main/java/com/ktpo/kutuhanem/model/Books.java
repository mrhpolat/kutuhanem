package com.ktpo.kutuhanem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="writerid")
	private int writerId;
	@Column(name="booktypeid")
	private int bookTyepId;
	@Column(name="bookcatid")
	private int bookCatId;
	@Column(name="totalstock")
	private int totalStock;
	@Column(name="publisherid")
	private int publisherId;
	@Column(name="isactive")
	private boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public int getBookTyepId() {
		return bookTyepId;
	}

	public void setBookTyepId(int bookTyepId) {
		this.bookTyepId = bookTyepId;
	}

	public int getBookCatId() {
		return bookCatId;
	}

	public void setBookCatId(int bookCatId) {
		this.bookCatId = bookCatId;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCatId;
		result = prime * result + bookTyepId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + publisherId;
		result = prime * result + totalStock;
		result = prime * result + writerId;
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
		Books other = (Books) obj;
		if (bookCatId != other.bookCatId)
			return false;
		if (bookTyepId != other.bookTyepId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publisherId != other.publisherId)
			return false;
		if (totalStock != other.totalStock)
			return false;
		if (writerId != other.writerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", description=" + description + ", writerId=" + writerId
				+ ", bookTyepId=" + bookTyepId + ", bookCatId=" + bookCatId + ", totalStock=" + totalStock
				+ ", publisherId=" + publisherId + ", isActive=" + isActive + "]";
	}

}
