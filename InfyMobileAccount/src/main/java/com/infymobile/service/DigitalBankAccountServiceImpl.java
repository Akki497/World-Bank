package com.infymobile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infymobile.entity.BankAccountEntity;
import com.infymobile.entity.DigitalBankAccountEntity;
import com.infymobile.exception.ExceptionConstants;
import com.infymobile.exception.InfyMeMobileException;
import com.infymobile.repository.AccountRepository;
import com.infymobile.repository.DigitalBankAccountRepository;
import com.infymobile.utility.OtpUtility;

@Service(value = "digitalBankAccountService")
public class DigitalBankAccountServiceImpl implements DigitalBankAccountService {
	

	@Autowired private DigitalBankAccountRepository bankAccountRepository;
	
	@Autowired private AccountRepository repository;
	
	
	public String linkAccount(Long  mobileNo, Long  accountNo) throws InfyMeMobileException{
		
		Optional<BankAccountEntity> optional= repository.findByAccountNumberAndUserEntity_MobileNumber(accountNo, mobileNo);
		if(optional.isEmpty()) {
			throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		}
		BankAccountEntity accountEntity = optional.get();
		DigitalBankAccountEntity digitalBankAccountEntity = new DigitalBankAccountEntity();
		
		digitalBankAccountEntity.setAccountType(accountEntity.getAccountType());
		digitalBankAccountEntity.setUserEntity(accountEntity.getUserEntity());
		digitalBankAccountEntity.setBankAccountEntity(accountEntity);

		DigitalBankAccountEntity updatedDigitalBankAccountEntity = bankAccountRepository.save(digitalBankAccountEntity);
		return "Account linked successfully and digital Bank Id is : "+updatedDigitalBankAccountEntity.getDigitalBankingId();
		}
		
	
	
	
	public String linkAccount(Long  mobileNo, Long  accountNo, Integer OTP) throws InfyMeMobileException{
		
		Optional<BankAccountEntity> optional= repository.findByAccountNumberAndUserEntity_MobileNumber(accountNo, mobileNo);
		if(optional.isEmpty()) {
			throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		}
			
		Integer generetedOTP = new OtpUtility().sendOTP();
		if(!generetedOTP.equals(OTP)) {
					throw new InfyMeMobileException(ExceptionConstants.OTP_DOESNOT_MATCH.toString());
		}
		BankAccountEntity accountEntity = optional.get();
		DigitalBankAccountEntity digitalBankAccountEntity = new DigitalBankAccountEntity();
		
		digitalBankAccountEntity.setAccountType(accountEntity.getAccountType());
		digitalBankAccountEntity.setUserEntity(accountEntity.getUserEntity());
		digitalBankAccountEntity.setBankAccountEntity(accountEntity);

		DigitalBankAccountEntity updatedDigitalBankAccountEntity = bankAccountRepository.save(digitalBankAccountEntity);
		return "Account linked successfully and digital Bank Id is : "+updatedDigitalBankAccountEntity.getDigitalBankingId();
		}
	
	
	public Double checkBalance(Long  mobileNo, Long  accountNo) throws InfyMeMobileException{
	
		Optional<DigitalBankAccountEntity> optional = bankAccountRepository.findByUserEntity_MobileNumberAndBankAccountEntity_AccountNumber(mobileNo, accountNo);
		if(optional.isEmpty()) {
			throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNT_IS_LINKED.toString());
		}
		DigitalBankAccountEntity accountEntity = optional.get();
		return accountEntity.getBankAccountEntity().getBalance();
 
	}

}
