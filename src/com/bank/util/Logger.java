package com.bank.util;


public class Logger {
	
	public void info(String msg) {
		System.out.println(msg);
	}

	public void error(String msg) {
		System.err.println(msg);
	}

	public static Logger getLogger(Class<?> type) {
		return new Logger();
	}
	
	
}
