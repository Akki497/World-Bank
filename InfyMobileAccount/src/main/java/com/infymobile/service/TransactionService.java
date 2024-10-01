package com.infymobile.service;

import java.util.List;

import com.infymobile.dto.TransactionDTO;
import com.infymobile.exception.InfyMeMobileException;

public interface TransactionService {

	public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileException;
	
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileException;
	
	
}
