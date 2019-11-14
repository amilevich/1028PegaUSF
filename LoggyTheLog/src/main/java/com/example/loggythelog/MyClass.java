package com.example.loggythelog;

import org.apache.log4j.Logger;

public class MyClass {
	
	final static Logger loggy = Logger.getLogger(MyClass.class);
	
	public static void main(String[] args) {
		
		loggy.info("this is info");
		loggy.error("message about error");
		loggy.fatal("fatal message");
		loggy.warn("warning message");
	}

}
