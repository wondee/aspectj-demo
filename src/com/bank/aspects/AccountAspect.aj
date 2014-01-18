package com.bank.aspects;
import com.bank.model.with.Account;
import com.bank.util.Logger;


public aspect AccountAspect {

	private static final String VALUE_IS_NEGATIVE = "value is negative";
	private static final String NOT_ENOUGH_MONEY = "not enough money";
	
	private static Logger com.bank.model.with.Account.log = Logger.getLogger(Account.class);
	
	pointcut amountMethod(double amount, Account account) : 
		execution(public * com.bank.model.with.Account.*(.., double))
			&& args(.., amount)
			&& this(account);
	
	pointcut withdraw(double amount, Account account) : 
		amountMethod(amount, account) && execution(* * ..withdraw(double));
	
	pointcut callTranfer(Account account) : 
		execution(public * com.bank.model.with.Account.transfer(..))
			&& target(account);
	

	before(double amount, Account account) : amountMethod(amount, account) {
		if (amount < 0) {
			com.bank.model.with.Account.log.error(VALUE_IS_NEGATIVE);
			throw new IllegalArgumentException(VALUE_IS_NEGATIVE);
		}
	}
	
	before(double amount, Account account) : withdraw(amount, account) {
		if (amount > account.getAmount()) {
			com.bank.model.with.Account.log.error(NOT_ENOUGH_MONEY);
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
	}
	
	
	after(double amount, Account account) returning : amountMethod(amount, account) {
		String name = thisJoinPointStaticPart.getSignature().getName();
		com.bank.model.with.Account.log.info(
				
				name + " " + amount + " for account " + account.getId());
	}
	
	
	
}
