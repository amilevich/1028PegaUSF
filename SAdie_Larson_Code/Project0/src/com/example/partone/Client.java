package com.example.partone;

import java.util.HashMap;
import java.util.Map;

public interface Client {
	public abstract void createAccounts(Map<String, Double> accounts2);
	public abstract void accessAccounts(HashMap<Integer, Account> bankAccounts, int accountKeyAccess);
	public abstract int apply(HashMap<Integer, Account> bankAccounts, int accountKeyPassed);
	public abstract void viewInformation();
	public abstract double deposit();
	public abstract double withdraw();
	public abstract void transfer(Map<String, Double> accounts2);
	public void accessJoint(HashMap<Integer, Account> bankAccounts);
	public void accessSingleAccount();
	
}
