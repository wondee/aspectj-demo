package com.bank.model.with;


public class SomeObject {
	public void beforeMethodWithout(String a) {
		System.out.println(a);
	}
	
	public void beforeMethodWith(String a) {
		System.out.println(a);
	}
	
	
	public void afterMethodWithout(String a) {
		System.out.println(a);
	}
	
	public void afterMethodWith(String a) {
		System.out.println(a);
	}
	
	public void afterMethodWithThrow(String a) {
		if (a == null) {
			throw new NullPointerException("null");
		}
	}
	
	public String afterMethodWithReturnWithout(String a) {
		if (a == null) {
			return "";
		} else {
			return a;
		}
	}
	
	public String afterMethodWithReturn(String a) {
		if (a == null) {
			return "";
		} else {
			return a;
		}
	}
	
	
	public String aroundWithout(String a) {
		return a + "!";
	}
	
	public String aroundWith(String a) {
		return a + "!";
	}
	
}
