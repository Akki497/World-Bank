package com.infymobile.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "digital_bank_account")
public class DigitalBankAccountEntity {

	@Id
	@GeneratedValue(generator = "digital_banking_id")
	@GenericGenerator(name = "digital_banking_id",type = com.infymobile.utility.DigitalBankingIdGenerator.class)
	private String digitalBankingId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mobile_number")
	private UserEntity userEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_number")
	private BankAccountEntity  bankAccountEntity;
	
	private String accountType;

	public DigitalBankAccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DigitalBankAccountEntity(UserEntity userEntity, BankAccountEntity bankAccountEntity, String accountType) {
		super();
		this.userEntity = userEntity;
		this.bankAccountEntity = bankAccountEntity;
		this.accountType = accountType;
	}



	public String getDigitalBankingId() {
		return digitalBankingId;
	}

	public void setDigitalBankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}

	 public UserEntity getUserEntity() {
		return userEntity;
	}
	 
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public BankAccountEntity getBankAccountEntity() {
		return bankAccountEntity;
	}
	
	public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
		this.bankAccountEntity = bankAccountEntity;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "DigitalBankAccountEntity [digitalBankingId=" + digitalBankingId + ", userEntity=" + userEntity
				+ ", bankAccountEntity=" + bankAccountEntity + ", accountType=" + accountType + "]";
	}
	
}
