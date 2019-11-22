import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Test;
import com.project.pt1.Customer;
import com.project.pt1.Employee;
import com.project.pt1.MainDriver;
import com.project.pt1.Admin;




public class CustomerTest {
	
	ArrayList<Customer> custList = new ArrayList<Customer>();
	Customer customer = new Customer("caio","12345");
	Employee employee = new Employee("caio","1234");
	Admin admin = new Admin("caio","1234");
	
	
	
	@Test
	public void duplicateCheck() {
	assertEquals("Should return true, as a customer named 'Caio' has just been added.",true,MainDriver.duplicateCheck("caio"));
	//Reads serialized array and returns true if username passed is taken.
	}
	
	@Test
	public void duplicateCheckTwo() {
	assertEquals("Should return false, as a customer named 'Caio2' is not there.",false,MainDriver.duplicateCheck("caio2"));
	//Reads serialized array and returns true if username passed is taken.
	}
	
	
	
	

}
