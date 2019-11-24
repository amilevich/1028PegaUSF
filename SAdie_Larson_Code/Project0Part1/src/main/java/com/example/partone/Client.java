package com.example.partone;

import java.util.HashMap;
import java.util.Map;

public interface Client {
	public abstract void createAccounts(Map<String, Float> accounts2);

	public abstract void accessAccounts(HashMap<Integer, Account> bankAccounts, int accountKeyAccess);

	public abstract int apply(HashMap<Integer, Account> bankAccounts, int accountKeyPassed);

	public abstract void viewInformation(HashMap<Integer, Account> bankAccounts);

	public abstract float deposit(String acc);

	public abstract float withdraw(String acc);

	public abstract void transfer(int key, int otherKey,  HashMap<Integer, Account> bankAccounts);
	
	public abstract void transferBetween(int key, int otherKey, HashMap<Integer, Account> bankAccounts);

	public void accessJoint(HashMap<Integer, Account> bankAccounts, int Hashkey);

	public void accessSingleAccount(HashMap<Integer, Account> bankAccounts, int hashKey);

}
