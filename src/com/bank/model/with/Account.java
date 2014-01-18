package com.bank.model.with;


public class Account {
	private double amount = 0.0;
	private int id;
	
	public Account(int id) {
		this.id = id;
	}
	
	public void deposit(double value) {
		amount += value;
	}
	
	public void withdraw(double value) {
		amount -= value;
	}
	
	public void transfer(Account other, double value) {
		withdraw(value);
		other.deposit(value);
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getId() {
		return id;
	}
}
