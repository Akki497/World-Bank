package com.infymobile.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.infymobile.entity.BankAccountEntity;
import com.infymobile.entity.UserEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class BankAccountDTO {

	@NotNull(message = "Can not be null")
	@Min(value = 1000000L,message = "minimum length should be 7")
	private Long accountNumber;
	
	@NotNull(message = "Can not be null")
	@Length(min = 5,max = 15, message = "minimum length should be 5 and maximum length should be 15")
	private String bankName;

	@Min(value = 0,message = "Minimum must be 0")
	private Double balance;
	
	@NotNull(message = "Can not be null")
	@Length(min = 1,max = 10, message = "minimum length should be 1 and maximum length should be 10")
	private String accountType;
	
	@NotNull(message = "Can not be null")
	@Length(min = 1,max = 15, message = "minimum length should be 1 and maximum length should be 15")
	private String ifscCode;
	
	@Past(message = "Account Opening date must be past date")
	private LocalDate openingDate;
	
	@NotNull(message = "Can not be null")
	@Min(value = 1000000000L, message = "minimum length should be 10 and maximum length should be 10")
	private Long mobileNumber;

	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountDTO(String bankName, Double balance, String accountType, String ifscCode,
			LocalDate openingDate, Long mobileNumber) {
		super();
		this.bankName = bankName;
		this.balance = balance;
		this.accountType = accountType;
		this.ifscCode = ifscCode;
		this.openingDate = openingDate;
		this.mobileNumber = mobileNumber;
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

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public static BankAccountEntity convertToEntity(BankAccountDTO accountDTO) {
		BankAccountEntity accountEntity = new BankAccountEntity();
		accountEntity.setAccountNumber(accountDTO.getAccountNumber());
		accountEntity.setBankName(accountDTO.getBankName());
		accountEntity.setAccountType(accountDTO.getAccountType());
		accountEntity.setIfscCode(accountDTO.getIfscCode());
		accountEntity.setBalance(accountDTO.getBalance());
		accountEntity.setOpeningDate(accountDTO.getOpeningDate());
		UserEntity user = new UserEntity();
		user.setMobileNumber(accountDTO.getMobileNumber());
		accountEntity.setUserEntity(user);
		return accountEntity;
	}
	
	public static BankAccountDTO convertToDTO(BankAccountEntity accountEntity) {
		BankAccountDTO accountDTO = new BankAccountDTO();
		accountDTO.setAccountNumber(accountEntity.getAccountNumber());
		accountDTO.setBankName(accountEntity.getBankName());
		accountDTO.setAccountType(accountEntity.getAccountType());
		accountDTO.setIfscCode(accountEntity.getIfscCode());
		accountDTO.setBalance(accountEntity.getBalance());
		accountDTO.setOpeningDate(accountEntity.getOpeningDate());
		accountDTO.setMobileNumber(accountEntity.getUserEntity().getMobileNumber());
		return accountDTO;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance=" + balance
				+ ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
}
