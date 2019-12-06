package P1Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.TreeMap;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import Reimbursement.DAO;
import Reimbursement.Ticket;
import Reimbursement.User;

public class DAOTester {

	@Test
	public void DAOTest(){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			User u = new User("TESTEMAILDONOTUSE@b.c", DatatypeConverter.printHexBinary(md5.digest("pass".getBytes())), "first", "last", false);
			User u1 = new User("ANOTHERTESTEMAIL@d.e", DatatypeConverter.printHexBinary(md5.digest("pass".getBytes())), "notlast", "notfirst", true);
			User u2 = new User("NOT AN EMAIL.COM", DatatypeConverter.printHexBinary(md5.digest("anotherpass".getBytes())), "anotherfirst", "anotherlast", false);
			Ticket t0 = new Ticket("TESTEMAILDONOTUSE@b.c", 108.64, "dollars are missing", (byte)1, Timestamp.valueOf("2011-4-24 16:44:34"));
			Ticket t1 = new Ticket("ANOTHERTESTEMAILPLZIGNORE@d.f", 9345, "more money gone", (byte)2, Timestamp.valueOf("2012-5-16 15:44:32"));
			Ticket t2 = new Ticket("TESTEMAILDONOTUSE@b.c", 999999, "I LOST THE FARM", (byte)3, Timestamp.valueOf("2013-10-6 11:22:27"));
			DAO dao = new DAO(false);
			TreeMap<Integer, Ticket> tickets;
			
			assertTrue(dao.storeUser(u));
			assertFalse(dao.storeUser(u));
			assertTrue(dao.storeTicket(t0));
			assertFalse(dao.storeTicket(t1));
			assertTrue(dao.storeTicket(t2));
			assertFalse(dao.storeUser(u2));
			
			assertTrue(dao.getUser(u.getEmail()) != null);
			assertTrue(u.equals(dao.getUser(u.getEmail())));
			
			tickets = dao.getTickets(u1);
			assertTrue(tickets != null);
			assertTrue(tickets.size() > 1);
			
			tickets = dao.getTickets(u);
			assertTrue(tickets != null);
			assertEquals(tickets.size(), 2);
			assertTrue(tickets.firstKey() != -1);
			assertTrue(tickets.lastKey() != -1);
			assertTrue(tickets.get(tickets.firstKey()).equals(t0));
			assertTrue(tickets.lastEntry().getValue().equals(t2));
			
			assertTrue(dao.modTicket(tickets.firstKey(), true));
			assertTrue(dao.modTicket(tickets.lastKey(), false));
			
			tickets = dao.getTickets(u);
			assertFalse(tickets.firstEntry().getValue().equals(t0));
			assertEquals(tickets.firstEntry().getValue().getStatus(), 1);
			assertEquals(tickets.lastEntry().getValue().getStatus(), -1);
			
			assertFalse(dao.modTicket(tickets.firstKey(), true));
			assertFalse(dao.modTicket(tickets.lastKey(), true));
			assertFalse(dao.modTicket(tickets.firstKey(), false));
			assertFalse(dao.modTicket(tickets.lastKey(), false));
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.printf("%s", e.getMessage());
			fail();
		}
	}
}
