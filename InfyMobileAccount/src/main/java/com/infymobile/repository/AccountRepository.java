package com.infymobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infymobile.entity.BankAccountEntity;
import com.infymobile.exception.InfyMeMobileException;

@Repository
public interface AccountRepository extends JpaRepository<BankAccountEntity, Long> {


	public List<BankAccountEntity> findByUserEntity_MobileNumber(Long mobileNumber);
	
	public Optional<BankAccountEntity> findByAccountNumberAndUserEntity_MobileNumber(Long accountNo,Long mobileNo) throws InfyMeMobileException;
	
	public Double getBalanceByAccountNumberAndUserEntity_MobileNumber(Long AccountNo,Long MobileNo) throws InfyMeMobileException;
	
}
