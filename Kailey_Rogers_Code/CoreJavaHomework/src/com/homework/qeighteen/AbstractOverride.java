package com.homework.qeighteen;

public class AbstractOverride extends AbstractClassCreator {

	@Override
	public boolean checkForCaps(String capCheck) {
		if (capCheck == capCheck.toLowerCase()) {
			return false;
		}
		return true;

	}

	@Override
	public String convertToUpper(String upConvert) {
		return upConvert.toUpperCase();
	}

	@Override
	public int convertToInt(String toBeString) {
		return Integer.parseInt(toBeString) + 10;
	}

}
