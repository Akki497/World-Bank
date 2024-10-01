package com.infymobile.utility;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DigitalBankingIdGenerator implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter=1005;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
	
		return "w_"+(counter++);
	}
}
