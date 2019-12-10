package com.example.test;

import static org.junit.Assert.assertTrue;
import java.sql.Timestamp;
import org.junit.Test;
import com.example.dao.ReimburstmentDaoImpl;
import com.example.entitys.Reimburstment;
import com.example.entitys.Role;
import com.example.entitys.Status;
import com.example.entitys.Type;
import com.example.entitys.User;



public class ReimburstmentTest {
	
	private Role role = new Role(10000000, "USER");
	private User user = new User(10000000, "user", "user", "user", "notengo@notengo.com", role);
	private Type type = new Type (10000004, "LODGING");
	private Status status = new Status(10000003, "PENDING");
	private Reimburstment reimburstment = new Reimburstment(1000, 30, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "EXAMPLE", null , user, status, type, user);
	
	private ReimburstmentDaoImpl reimburstmentDaoImpl = new ReimburstmentDaoImpl();
	
	
	@Test
	public void insertReimburstmentTest() {
		assertTrue("ok", reimburstmentDaoImpl.insert(reimburstment));
	}
	
	@Test
	public void updateReimburstmentTest() {
			
		assertTrue("ok", reimburstmentDaoImpl.update(reimburstment));
	}
	
	
	@Test
	public void deleteReimburstmentTest() {
		assertTrue("ok", reimburstmentDaoImpl.delete(reimburstment));
	}
	

}	


