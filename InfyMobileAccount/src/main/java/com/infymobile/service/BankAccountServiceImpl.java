package com.infymobile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infymobile.dto.BankAccountDTO;
import com.infymobile.entity.BankAccountEntity;
import com.infymobile.exception.ExceptionConstants;
import com.infymobile.exception.InfyMeMobileException;
import com.infymobile.repository.AccountRepository;

@Service(value = "bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public String createAccount(BankAccountDTO accountDTO) throws InfyMeMobileException {
		BankAccountEntity accountEntity = BankAccountDTO.convertToEntity(accountDTO);
		return "Account created successfully and your account no is : "+ accountRepository.save(accountEntity).getAccountNumber().toString(); 
	}
	
	
	public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileException{
		
		List<BankAccountEntity> bankAccountEntities = accountRepository.findByUserEntity_MobileNumber(mobileNo);
		if(bankAccountEntities.isEmpty()) {
			throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		}
		
		List<BankAccountDTO> accountDTOs = new ArrayList<>();
		for(BankAccountEntity entity:bankAccountEntities) {
			accountDTOs.add(BankAccountDTO.convertToDTO(entity));
		}
			return accountDTOs;
	}
}
	

