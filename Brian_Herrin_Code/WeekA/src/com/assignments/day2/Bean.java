package com.assignments.day2;

public class Bean {
	// proper encapsulation guidelines in defining the fields and getters/setters
	// three custom methods with at least one being static and one being a varargs
	// method

	private String name;
	private boolean isMature;

	// In celsius. All beans are assumed to be in the same field and affected
	// equally by the weather
	static int currentTemperature;
	private int numOfDaysTilMaturity;
	private int score;

	public Bean() {

	}
	public Bean(String name, int numOfDaysTilMaturity) {
		this.name = name;
		this.numOfDaysTilMaturity = numOfDaysTilMaturity;
	}

	// Getters
	public String getName() {
		return name;
	}

	public boolean getMaturity() {
		return isMature;
	}

	public int getNumOfDaysTilMaturity() {
		if (numOfDaysTilMaturity < 0) {
			numOfDaysTilMaturity = 0;
		}

		return numOfDaysTilMaturity;
	}

	public static int getCurrentTemperature() {
		return currentTemperature;
	}

	public int getScore() {
		return score;
	}

	// Setters
	public void setName(String input) {
		name = input;
	}

	public void setMaturity(boolean input) {
		if (input == true) {
			numOfDaysTilMaturity = 0;
		}
		if (input == false) {
			if (numOfDaysTilMaturity <= 0) {
				numOfDaysTilMaturity = 1;
			}
		}
		
		isMature = input;
	}

	public void setNumOfDaysTilMaturity(int input) {
		if (input < 0) {
			input = 0;
		}

		numOfDaysTilMaturity = input;
	}

	public  void setCurrentTemperature(int input) {
		if(input < -273) {
			input = -273;
		} else if(input > 100){
			input = 100;
		}
		
		currentTemperature = input;
	}

	// Calculations
	public int growBean(int... temperaturesRecordedDaily) {
		for (int i = 0; i < temperaturesRecordedDaily.length; i++) {
			currentTemperature = temperaturesRecordedDaily[i];
			if (numOfDaysTilMaturity > 0) {
				numOfDaysTilMaturity--;
			} else {
				setMaturity(true);
				continue;
			}
			if(isMature == false) {
				if (currentTemperature > 35) {
					
				} else if (currentTemperature < 25) {
					
				} else {
					score += 1;
				}
			}
		}
		System.out.println(name + " Score: " + score);
		return score;
	}

}
