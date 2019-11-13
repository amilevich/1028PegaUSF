package com.exampke.exceptions;

public class CustomDriver {

	public static void main(String[] args) {

		MyCustomException myEx = new MyCustomException("This is an exception");
		MyCustomException myEx2 = new MyCustomException("Pineapples on pizza?", myEx);
		MyCustomException myEx3 = new MyCustomException("Toilet paper wrong direction", myEx2);

//		try {
//			throw myEx;
//		}catch(MyCustomException e) {
//			e.printStackTrace();
//		}catch(Exception e) {
//			System.out.println("In excption catch");
//		}
		
//		try {
//			throw myEx3;
//		}catch(MyCustomException e) {
//			e.printStackTrace();
//		}catch(Exception e) {
//			System.out.println("In excption catch");
//		}
		
		MyCustomRuntimeException myRex = new MyCustomRuntimeException("javaScipt is okay", myEx3);
		
		try {
			throw myRex;
		}catch(MyCustomRuntimeException e) {
			e.printStackTrace();
		}catch(RuntimeException e) {
			System.out.println("In excption catch");
		}
	} 

}
