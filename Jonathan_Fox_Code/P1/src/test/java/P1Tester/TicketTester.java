package P1Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Timestamp;

import org.junit.Test;

import Reimbursement.Ticket;

public class TicketTester {

	@Test
	public void ticketTest() {
		try {
			Ticket t0 = new Ticket("a@b.c", 108.64, "dollars are missing", (byte)3, Timestamp.valueOf("2012-5-22 17:42:34"));
			Ticket t1 = new Ticket("e@d.f", 9345, "more money gone", (byte)2, Timestamp.valueOf("2017-5-22 16:44:34"));
			Ticket t2 = new Ticket("e@d.f", 9345, "more money gone", (byte)2, Timestamp.valueOf("2017-5-22 16:44:34"));
			
			assertTrue(t1.equals(t2));
			assertEquals(t0.getStatus(), 0);
			assertTrue(t0.deny());
			assertFalse(t0.deny());
			assertFalse(t0.approve());
			assertEquals(t0.getStatus(), -1);
			assertTrue(t1.approve());
			assertEquals(t1.getStatus(), 1);
			assertFalse(t1.equals(t2));
			
		} catch (Exception e) { fail(); }
	}
}
