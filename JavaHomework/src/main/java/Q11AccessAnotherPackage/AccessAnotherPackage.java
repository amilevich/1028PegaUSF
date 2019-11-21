package Q11AccessAnotherPackage;

import Q11AccessAnotherPackageB.AccessAnotherPackageB;

public class AccessAnotherPackage {

	public static void main(String[] args) {
		
		System.out.println("The 2 floats in the other package are: "+AccessAnotherPackageB.num1+" and "+AccessAnotherPackageB.num2);
	}
}
