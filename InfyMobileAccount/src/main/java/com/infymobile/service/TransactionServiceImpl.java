package com.infymobile.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infymobile.dto.TransactionDTO;
import com.infymobile.entity.BankAccountEntity;
import com.infymobile.entity.TransactionEntity;
import com.infymobile.exception.ExceptionConstants;
import com.infymobile.exception.InfyMeMobileException;
import com.infymobile.repository.AccountRepository;
import com.infymobile.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service("TransactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired private AccountRepository accountRepository;
	
	@Autowired private TransactionRepository transactionRepository;
	
	@Transactional
	public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileException{
		 Optional<BankAccountEntity> optional = accountRepository.findById(transactionDTO.getSenderAccountNumber());
		 if(optional.isEmpty()){
			 throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		 }
		 BankAccountEntity senderEntity = optional.get();
		 if(senderEntity.getBalance()>transactionDTO.getAmmount()) {
			 
			 Optional<BankAccountEntity> optional2 = accountRepository.findById(transactionDTO.getReceiverAccountNumber());
			 
			 if(optional2.isEmpty()){
				 throw new InfyMeMobileException(ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
			 }
			 
			 BankAccountEntity recieverEntity = optional2.get();
			 
			 Double senderUpdatedBalance = senderEntity.getBalance()-transactionDTO.getAmmount();
			 Double receiverUpdatedBalance = recieverEntity.getBalance()+transactionDTO.getAmmount();
		
			 senderEntity.setBalance(senderUpdatedBalance);
			 recieverEntity.setBalance(receiverUpdatedBalance);
			 
			 accountRepository.save(senderEntity);
			 accountRepository.save(recieverEntity);
			 
			 TransactionEntity transactionEntity = TransactionDTO.convertToEntity(transactionDTO);
			 Integer transactionId = transactionRepository.save(transactionEntity).getTransactionId();
			 return "Transaction successfull. Your Transaction Id : "+transactionId;
			 
		 }
		throw new InfyMeMobileException(ExceptionConstants.INSUFFICIENT_FUNDS.toString());
	}
	
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileException {
		
		 List<TransactionEntity> entities = transactionRepository.findByPaidTo(mobileNo);
		 if(entities.isEmpty()) {
			 throw new InfyMeMobileException(ExceptionConstants.NO_ACTIVE_TRANSACTIONS.toString());
		 }
		 List<TransactionDTO> dtos = entities.stream().map(TransactionDTO::convertToDTO).collect(Collectors.toList());
		 return dtos;
	}
}
