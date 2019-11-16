package com.example.exception;

public class CustomDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCustomException myEx = new MyCustomException("This is an exception");
		MyCustomException myEx2 = new MyCustomException("Pineapples on pizza?" , myEx);
		MyCustomException myEx3 = new MyCustomException("Toilet Paper wrong direction" , myEx2);
		
		
		MyCustomRuntimeException myRex = new MyCustomRuntimeException("Javascript is ok", myEx3);
//		try {
//			throw myEx3;
//		}catch(MyCustomException e) {
//			e.printStackTrace();
//		}
		
		try {
			throw myRex;
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

}
