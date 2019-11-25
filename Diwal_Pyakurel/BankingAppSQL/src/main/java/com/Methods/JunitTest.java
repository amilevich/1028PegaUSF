package com.Methods;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.admin.Admin;
import com.dao.DaoAccountsTml;
import com.dao.DaoProfilesTmpl;
import com.dao.DaoRegistrationTmpl;
import com.employee.Employee;
import com.profiles.Customers;
import com.profiles.Profiles;

public class JunitTest {
	
	static Profiles currentUser;
	static Admin bankAdmin = new Admin();
	static Employee bankEmployee = new Employee();
	public final static Logger bankloggy = Logger.getLogger(Logger.class);

	public static DaoRegistrationTmpl regs = new DaoRegistrationTmpl();
	public static DaoProfilesTmpl profs = new DaoProfilesTmpl();
	public static DaoAccountsTml accts = new DaoAccountsTml();
	static Scanner sc = new Scanner(System.in);


}
