package com.example.homework;
import com.example.homework.q1package1.VariableClass;
public class Q11 {

	// Write a program that would access two float-variables from a class that
	// exists in another package. Note, you will need to create two packages to
	// demonstrate the solution.
	public void accessFloats() {
		VariableClass vc  = new VariableClass();
		float accessClassVar1 = vc.getVar1();
		float accessClassVar2 = vc.getVar2();
		float sum = accessClassVar1 + accessClassVar2;
		System.out.println("Addittion of flaots in another package " + sum);
	}

}
