package com.infymobile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransactionEntity {

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	private String modeOfTransaction;
	
	private Long paidTo;
	
	private Long receiverAccountNumber;
	
	private Double amount;
	
	private LocalDateTime transactionDateTime;
	
	private String remarks;
	
	private Long paidFrom;
	
	private Long senderAccountNumber;

	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionEntity(Integer transactionId, String modeOfTransaction, Long paidTo, Long receiverAccountNumber,
			Double amount, LocalDateTime transactionDateTime, String remarks, Long paidFrom, Long senderAccountNumber) {
		super();
		this.transactionId = transactionId;
		this.modeOfTransaction = modeOfTransaction;
		this.paidTo = paidTo;
		this.receiverAccountNumber = receiverAccountNumber;
		this.amount = amount;
		this.transactionDateTime = transactionDateTime;
		this.remarks = remarks;
		this.paidFrom = paidFrom;
		this.senderAccountNumber = senderAccountNumber;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public Long getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(Long paidTo) {
		this.paidTo = paidTo;
	}

	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPaidFrom() {
		return paidFrom;
	}

	public void setPaidFrom(Long paidFrom) {
		this.paidFrom = paidFrom;
	}

	public Long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(Long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	@Override
	public String toString() {
		return "TransactionEntity [transactionId=" + transactionId + ", modeOfTransaction=" + modeOfTransaction
				+ ", paidTo=" + paidTo + ", receiverAccountNumber=" + receiverAccountNumber + ", amount=" + amount
				+ ", transactionDateTime=" + transactionDateTime + ", remarks=" + remarks + ", paidFrom=" + paidFrom
				+ ", senderAccountNumber=" + senderAccountNumber + "]";
	}
	
}
