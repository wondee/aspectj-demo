package com.bank.model.pure;

import com.bank.util.Logger;

public class Account {
	
	private static final Logger log = Logger.getLogger(Account.class);
	
	private static final String NOT_ENOUGH_MONEY = "not enough money";
	private static final String VALUE_IS_NEGATIVE = "value is negative";

	private double amount = 0.0;
	private int id;
	
	public Account(int id) {
		this.id = id;
	
	}
	
	public void deposit(double value) {
		if (value  < 0) {
			log.error(VALUE_IS_NEGATIVE);
			throw new IllegalArgumentException(VALUE_IS_NEGATIVE);
		}

		amount += value;
		
		log.info("deposit " + value);
	}
	
	public void withdraw(double value) {
		if (value  < 0) {
			log.error(VALUE_IS_NEGATIVE);
			throw new IllegalArgumentException(VALUE_IS_NEGATIVE);
		}
		
		if (value > amount) {
			log.error(NOT_ENOUGH_MONEY);
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
		
		amount -= value;

		log.info("withdraw " + value + " from " + id);
	}
	
	public void transfer(Account other, double value) {
		if (value  < 0) {
			log.error(VALUE_IS_NEGATIVE);
			throw new IllegalArgumentException(VALUE_IS_NEGATIVE);
		}
		
		withdraw(value);
		other.deposit(value);
		
		log.info("transfer ");
	}
	
}
