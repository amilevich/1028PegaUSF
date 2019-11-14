package com.example.exceptions;

public class CustomDriver {

	public static void main(String[] args) {
		MyCustomException myEx = new MyCustomException("This is and exception");
		MyCustomException myEx2 = new MyCustomException("Pineapples on pizza?", myEx);
		MyCustomException myEx3 = new MyCustomException("Toilet paper wrong direction", myEx2);
		
		MyCustomRuntimeException myRex = new MyCustomRuntimeException("Javascript is okay", myEx3);
		
//		try {
//			throw myEx3;
//		}catch(MyCustomException e) {
//			e.printStackTrace();
//		}
		
		try {
			throw myRex;
		}catch(RuntimeException re) {
			re.printStackTrace();
		}

	}

}
