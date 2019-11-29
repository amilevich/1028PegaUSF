
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class EmployeeTest {



	Random r = new Random();
	int randomAccountNumber = r.nextInt((100000 - 1) + 1) + 1;
	int outOfRangeAccountNumber = 10000000;
	

	@Test
	public void generateRandomAccountNumberTrue() {
		assertTrue("account is in range: " + randomAccountNumber, randomAccountNumber > 0 && randomAccountNumber < 100000);
		System.out.println("Random Account Number Range True");
	}
	
	@Test
	public void generateRandomAccountNumberFalse() {
		assertFalse("account is out of range: " + outOfRangeAccountNumber, outOfRangeAccountNumber > 0 && outOfRangeAccountNumber < 100000);
		System.out.println("Random Account Number is out of Range True");
	}	
}

