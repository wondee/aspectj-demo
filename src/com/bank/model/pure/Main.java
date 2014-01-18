package com.bank.model.pure;


public class Main {
	
	
	public static void main(String[] args) {
		Account acc = new Account(42);
		Account acc2 = new Account(815);
		
		acc.deposit(50);
		
		acc.withdraw(20);
		
		acc.transfer(acc2, 10);
		
		acc2.withdraw(20);
	}
	
}
