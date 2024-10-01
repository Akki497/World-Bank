package com.infymobile.service;

import com.infymobile.exception.InfyMeMobileException;

public interface DigitalBankAccountService {

	public String linkAccount(Long  mobileNo, Long  accountNo) throws InfyMeMobileException;
	
	public String linkAccount(Long  mobileNo, Long  accountNo, Integer OTP) throws InfyMeMobileException;
	
	public Double checkBalance(Long  mobileNo, Long  accountNo) throws InfyMeMobileException;
}
