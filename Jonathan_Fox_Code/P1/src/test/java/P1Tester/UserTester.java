package P1Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import Reimbursement.User;

public class UserTester {

	@Test
	public void userTest() {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			User u = new User("a@b.c", DatatypeConverter.printHexBinary(md5.digest("pass".getBytes())), "first", "last", false);
			User u2 = new User("a@b.c", DatatypeConverter.printHexBinary(md5.digest("pass".getBytes())), "first", "last", false);

			
			assertTrue(u.isPass("pass"));
			assertFalse(u.isPass(("notpass")));
			assertEquals(u.getName()[0], "first");
			assertEquals(u.getName()[1], "last");
			assertTrue(u.equals(u2));

		} catch (Exception e) { fail(); }

	}
}
