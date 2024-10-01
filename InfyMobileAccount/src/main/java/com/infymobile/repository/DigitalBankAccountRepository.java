package com.infymobile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infymobile.entity.DigitalBankAccountEntity;
import com.infymobile.exception.InfyMeMobileException;

@Repository
public interface DigitalBankAccountRepository extends JpaRepository<DigitalBankAccountEntity, String> {
	
	public Optional<DigitalBankAccountEntity> findByUserEntity_MobileNumberAndBankAccountEntity_AccountNumber(Long mobileNo,Long AccountNo) throws InfyMeMobileException;
}
