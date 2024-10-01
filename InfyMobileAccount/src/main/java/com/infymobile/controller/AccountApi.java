package com.infymobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infymobile.dto.AccountDTO;
import com.infymobile.dto.BankAccountDTO;
import com.infymobile.dto.TransactionDTO;
import com.infymobile.exception.InfyMeMobileException;
import com.infymobile.service.BankAccountService;
import com.infymobile.service.DigitalBankAccountService;
import com.infymobile.service.TransactionService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class AccountApi {
	
	@Autowired private BankAccountService accountService;
	
	@Autowired private DigitalBankAccountService bankAccountService;
	
	@Autowired private TransactionService transactionService;
	
	
	@PostMapping("/accounts")
	public ResponseEntity<String> createAccount(@RequestBody @Valid BankAccountDTO accountDTO) throws InfyMeMobileException{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountDTO));
	}
	
	
	@GetMapping("/accounts/{mobileNo}")
	public ResponseEntity<List<BankAccountDTO>> listAccounts(@PathVariable Long mobileNo) throws InfyMeMobileException{
		
		return ResponseEntity.status(HttpStatus.OK).body(accountService.listAccounts(mobileNo));
	}
	
	@PostMapping("/accounts/{mobileNo}")
	public ResponseEntity<String> linkAccount(@PathVariable Long  mobileNo,@RequestBody AccountDTO accountDTO) throws InfyMeMobileException{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankAccountService.linkAccount(mobileNo, accountDTO.getAccountNo()));
	}
	
	
	@PostMapping("/accounts/{mobileNo}/{otp}")
	public ResponseEntity<String> linkAccount(@PathVariable Long  mobileNo,@PathVariable Integer otp,@RequestBody AccountDTO accountNo) throws InfyMeMobileException{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankAccountService.linkAccount(mobileNo, accountNo.getAccountNo(),otp));
	}
	
	@GetMapping("/accounts/balance/{mobileNo}")
	public ResponseEntity<Double> checkBalance(@PathVariable("mobileNo") Long  mobileNo,@RequestParam("accountNo") Long  accountNo) throws InfyMeMobileException{
		
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.checkBalance(mobileNo, accountNo));
	}
	
	@PutMapping("/accounts/fundtransfer")
	public ResponseEntity<String> fundTransfer(@RequestBody TransactionDTO transactionDTO) throws InfyMeMobileException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.fundTransfer(transactionDTO));
	}
	
	@GetMapping("/accounts/statement/{mobileNo}")
	public ResponseEntity<List<TransactionDTO>> accountStatement(@PathVariable Long mobileNo) throws InfyMeMobileException{
		return ResponseEntity.status(HttpStatus.OK).body(transactionService.accountStatement(mobileNo));
	}

}
