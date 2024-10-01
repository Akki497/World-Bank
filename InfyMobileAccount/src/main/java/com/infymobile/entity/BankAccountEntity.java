package com.infymobile.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(nullable = false)
	private String bankName;
	
	@Column(nullable = false)
	private Double balance;
	
	@Column(nullable = false)
	private String accountType;
	
	@Column(nullable = false)
	private String ifscCode;
	
	@Column(nullable = false)
	private LocalDate openingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mobile_number",nullable = false)
	private UserEntity userEntity;

	
	public BankAccountEntity() {
	}


	public BankAccountEntity(String bankName, Double balance, String accountType, String ifscCode,
			LocalDate openingDate, UserEntity userEntity) {
		super();
		this.bankName = bankName;
		this.balance = balance;
		this.accountType = accountType;
		this.ifscCode = ifscCode;
		this.openingDate = openingDate;
		this.userEntity = userEntity;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public LocalDate getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	@Override
	public String toString() {
		return "BankAccountEntity [accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance=" + balance
				+ ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate
				+ ", userEntity=" + userEntity + "]";
	}
	 
}
