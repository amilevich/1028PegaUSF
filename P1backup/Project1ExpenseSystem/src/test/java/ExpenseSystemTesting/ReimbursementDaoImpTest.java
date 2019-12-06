package ExpenseSystemTesting;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ExpenseSysDao.ReimbursementDaoImp;
import ExpenseSysModels.Reimbursement;

public class ReimbursementDaoImpTest {

		java.sql.Date d = new Date(System.currentTimeMillis());
		Reimbursement reimbursement = new Reimbursement(10, 50.50, d, null, "business lunch with client", 201, 0, 1, 3);
		ReimbursementDaoImp reimbursementDaoImp = new ReimbursementDaoImp();
		
		@Test
		public void areTwoReimbIDEq() {
			assertEquals("should return true", reimbursement.getReimbID(), reimbursementDaoImp.selectReimbById(10).getReimbID());
		}
}
