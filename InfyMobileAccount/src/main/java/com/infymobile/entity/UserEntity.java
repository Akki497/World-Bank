package com.infymobile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@Column(name = "mobile_number")
	private Long mobileNumber;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserEntity [mobileNumber=" + mobileNumber + "]";
	}
	
}
