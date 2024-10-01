package com.infymobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infymobile.entity.TransactionEntity;
import com.infymobile.exception.InfyMeMobileException;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

	public List<TransactionEntity> findByPaidTo(Long mobileNo) throws InfyMeMobileException;
}
