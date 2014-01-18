package com.bank.model.with;


public class SomeObject {

	
	public String someMethod(String a, String b) {
		System.out.println("a: " + a + "; b: " + b);
		return a + b;
	}
	
	public void someMethod2(String a) {
		
	}
	
	public void setSomeValue (Object o) {
		// ...
	}

	
	public static void main(String[] args) {
		SomeObject o = new SomeObject();
		System.out.println(o.someMethod("Hallo, ", "aspectj"));
		System.out.println(o.someMethod("hey!", "ho!"));
		
		
	}
}
