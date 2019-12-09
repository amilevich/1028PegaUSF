package ExpenseSystemTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import expenseSysDao.UsersDaoImp;
import expenseSysModels.User;


public class UsersDaoImpTest {
		
		User user = new User(101, "BillL", "p4ssw0rd", "Bill", "Lumbergh", "billlumbergh@somecompany.com", 1);
		UsersDaoImp usersDaoImp = new UsersDaoImp();
		
		@Test
		public void areTwoUsersEq() {
			assertEquals("should return true", user.getUserID(), usersDaoImp.selectUserByUserName("BillL").getUserID());
		}
}
