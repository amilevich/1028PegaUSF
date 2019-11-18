package com.example.exceptions;

public class ExceptionExampleHelper {
	
	public static void triggerException() {
		
		Throwable th = new Throwable();
		RuntimeException re = new RuntimeException();
		
		try {
			throw re;
		}catch(RuntimeException re1) {
			re.printStackTrace();
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void howToDuck() throws Exception {
		
		throw new RuntimeException();
	}

}
