package com.example.exceptions;

import java.util.InputMismatchException;

public class ExceptionExampleHelper {
	
	public static void howToDuck() throws Exception {
		throw new RuntimeException();
	}
	
	public static void triggerException() {
		Throwable th = new Throwable();
		RuntimeException re = new RuntimeException();
		
		try {
			throw new InputMismatchException();
		}catch(RuntimeException re2) {
			re.printStackTrace();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

}
