package com.infymobile.service;

import java.util.List;

import com.infymobile.dto.BankAccountDTO;
import com.infymobile.exception.InfyMeMobileException;

public interface BankAccountService {

	public String createAccount(BankAccountDTO accountDTO) throws InfyMeMobileException;
	
	public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileException;
	
}
