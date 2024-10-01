package com.infymobile.dto;

import java.time.LocalDateTime;

import com.infymobile.entity.TransactionEntity;

public class TransactionDTO {

	private Integer transactionId;
	
	private String modeOfTransaction;
	
	private Long paidTo;
	
	private Long receiverAccountNumber;
	
	private Double ammount;
	
	private LocalDateTime transactionDateTime;
	
	private String remarks;
	
	private Long paidFrom;
	
	private Long senderAccountNumber;

	public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDTO(Integer transactionId, String modeOfTransaction, Long paidTo, Long receiverAccountNumber,
			Double ammount, LocalDateTime transactionDateTime, String remarks, Long paidFrom,
			Long senderAccountNumber) {
		super();
		this.transactionId = transactionId;
		this.modeOfTransaction = modeOfTransaction;
		this.paidTo = paidTo;
		this.receiverAccountNumber = receiverAccountNumber;
		this.ammount = ammount;
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

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
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
	
	public static TransactionEntity convertToEntity(TransactionDTO dto) {
		TransactionEntity entity = new TransactionEntity();
		entity.setAmount(dto.getAmmount());
		entity.setModeOfTransaction(dto.getModeOfTransaction());
		entity.setPaidFrom(dto.getPaidFrom());
		entity.setPaidTo(dto.getPaidTo());
		entity.setSenderAccountNumber(dto.getSenderAccountNumber());
		entity.setReceiverAccountNumber(dto.getReceiverAccountNumber());
		entity.setTransactionDateTime(dto.getTransactionDateTime());
		entity.setTransactionId(dto.getTransactionId());
		return entity;
	}
	
	public static TransactionDTO convertToDTO(TransactionEntity entity) {
		TransactionDTO dto = new TransactionDTO();
		dto.setAmmount(entity.getAmount());
		dto.setModeOfTransaction(entity.getModeOfTransaction());
		dto.setPaidFrom(entity.getPaidFrom());
		dto.setPaidTo(entity.getPaidTo());
		dto.setSenderAccountNumber(entity.getSenderAccountNumber());
		dto.setReceiverAccountNumber(entity.getReceiverAccountNumber());
		dto.setTransactionDateTime(entity.getTransactionDateTime());
		dto.setTransactionId(entity.getTransactionId());
		return dto;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", modeOfTransaction=" + modeOfTransaction
				+ ", paidTo=" + paidTo + ", receiverAccountNumber=" + receiverAccountNumber + ", ammount=" + ammount
				+ ", transactionDateTime=" + transactionDateTime + ", remarks=" + remarks + ", paidFrom=" + paidFrom
				+ ", senderAccountNumber=" + senderAccountNumber + "]";
	}
	
}
