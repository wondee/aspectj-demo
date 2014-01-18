package com.bank.aspects;

public aspect SomeAspect {
	
	pointcut someMethod(String a, String b) : 
		execution(public String com.bank.model.with.SomeObject.someMethod(String, String)) 
		&& args(a, b);
	
	String around(String a, String b) : someMethod(a, b) {
		if (b.equals("aspectj")) {
			b = "Welt!";
		}
		
		String result = proceed(a, b);
		
		if (a.equals("hey!")) {
			proceed(b, a);
		}
		
		return "'" + result + "'";
		
	}
	
	before(String s) : execution(* * ..someMethod2(..)) && args(s) {
		System.out.println(s);
	}
	
	before(String s) : 
		execution(public void com.bank.model.with.SomeObject.set*(Object))
		&& args(s) {
		// ...
	}

	
}
