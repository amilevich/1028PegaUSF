package BankingAppTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BankingApp.FileUserManger;
import BankingApp.Users;

public class FileUserManagerTest {

	private FileUserManger t;
	private ByteArrayOutputStream bao;
	private ByteArrayInputStream bai;
	
	@Before
	public void setup() {
		byte[] buf = new byte[2000];
		bao = new ByteArrayOutputStream();
		bai = new ByteArrayInputStream(buf);
		PrintWriter userWriter = new PrintWriter(bao);
		BufferedReader userReader = new BufferedReader(new InputStreamReader(bai));
		
		t = new FileUserManger(userWriter, userReader);
		
	}
	
	@Test
	public void testSignup() {
		boolean res = t.signUp(new Users("test1", "pass1", "0"));
		Assert.assertTrue(res);
		Assert.assertEquals("test1,pass1,0\r\n", new String(bao.toByteArray()));
	}
	
	@Test
	public void testSignup2() {
		boolean res = t.signUp(new Users("test2", "pass2", "1"));
		Assert.assertTrue(res);
		Assert.assertEquals("test2,pass2,1\r\n", new String(bao.toByteArray()));
	}
}
