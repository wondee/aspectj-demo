package com.bank.aspects;

public aspect SomeAspect {
	
	before(String s) : execution(* * ..SomeObject.beforeMethodWith(..)) && args(s) {
		System.out.println(s);
	}
	
	after(String s) : execution(* * ..SomeObject.afterMethodWith(..)) && args(s) {
		System.out.println(s);
	}

	after(String s) throwing (NullPointerException e): execution(* * ..SomeObject.afterMethodWithThrow(..)) && args(s) {
		System.out.println(e.getMessage());
	}

	after(String s) returning (String a): execution(* * ..SomeObject.afterMethodWithReturn(..)) && args(s) {
		System.out.println(a);
	}
	
	
	String around(String s) : execution(* * ..SomeObject.aroundWith(..)) && args(s) {
		return proceed(s + s);
	}
}
