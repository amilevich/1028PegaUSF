package com.assignments.day3;

public abstract class Developer implements Person, Animal {
	// The "Developer" class name has the red-squiggly underline
	// Placed mouse focus on Developer class name
	// Told: "Duplicate default methods named think with the parameters () and ()
	// are
	// inherited from the types Animal and Person"
	// Options are to choose which default method to override.
	// I chose to Person and the following code appeared:
	/*
	 * @Override public void think() { // TODO Auto-generated method stub
	 * Person.super.think(); }
	 */
	@Override
	public void think() {
		// TODO Auto-generated method stub
		Person.super.think();
	}

}
