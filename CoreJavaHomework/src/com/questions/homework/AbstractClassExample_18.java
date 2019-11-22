package com.questions.homework;

public class AbstractClassExample_18 {

	public static void main(String[] args) {//call to abstact methods
		AbstractExample_18 abHolder = new AbstractExample_18();
		
		AbstractExample_18B abHolder2 = new AbstractExample_18();
		AbstractExample_18B.lower(null);
		abHolder2.upper(null);
		abHolder2.integer();

	}

}
