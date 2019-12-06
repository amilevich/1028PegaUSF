package Reimbursement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;
public class User {
	private String email, hashPass, firstName, lastName;
	private Boolean advisor;

	public User(String e, String p, String first, String last, boolean type) throws InstantiationException {
		
		if(e == null || e.equals("")) throw new InstantiationException("needs email");
		else email = e;
		
		if(p == null || p.equals("")) throw new InstantiationException("needs hashed password");
		else hashPass = p;
		
		if(first == null || first.equals("")) throw new InstantiationException("needs first name");
		else firstName = first;
		
		if(last == null || last.equals("")) throw new InstantiationException("needs last name");
		else lastName = last;
		
		advisor = type;
	}
	
	public Boolean isAdvisor() { return advisor; }
	public String getEmail() { return email; }
	public String getPass() { return hashPass; }
	
	public String[] getName() {
		String[] name = new String[2];
		
		name[0] = firstName;
		name[1] = lastName;
		
		return name;
	}
	
	//pass is unhashed password
	public boolean isPass(String pass) {
		MessageDigest md5 = null;
		try { md5 = MessageDigest.getInstance("MD5"); }
		catch (NoSuchAlgorithmException e) { System.out.printf("PANIC!!!!!!!!!\n"); }
		
		return hashPass.equals(DatatypeConverter.printHexBinary(md5.digest(pass.getBytes())));
	}
	
	public boolean equals(User u) {
		if(!u.getEmail().equals(email)) return false;
		if(!u.getPass().equals(hashPass)) return false;
		if(!u.getName()[0].equals(firstName)) return false;
		if(!u.getName()[1].equals(lastName)) return false;
		if(!u.isAdvisor() == u.isAdvisor()) return false;
		return true;
	}
}
