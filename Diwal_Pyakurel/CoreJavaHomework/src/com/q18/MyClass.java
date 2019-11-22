package com.q18;

public class MyClass extends MyAbstractClass {

	@Override
	public boolean checkUppercase(String string) {
		// TODO Auto-generated method stub
		String temp = string.toUpperCase();
		
		if(temp.equals(string)) {
			System.out.println("The letter is in upper cases");
			return true;
		}else {
			System.out.println("All the letters are not in upper case");
			return false;
		}
		
	}

	@Override
	public void convertUppercase(String string) {
		// TODO Auto-generated method stub
		String temp = string.toUpperCase();
		System.out.println("After converting to UpperCase: "+ temp);
		
	}

	@Override
	public int add(String string) {
		int temp = Integer.parseInt(string);	
		return temp + 10;
	}

}
