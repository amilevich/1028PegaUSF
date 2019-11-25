package Project0BankAccountM.Project0BankAccountM;

import java.util.List;

import Project0BankAccountM.Project0BankAccountM.Account;

public interface AccountDao 
{
	//CREATE
	public int insertAccount(Account _account);
	//READ
	public Account selectAccountByNumber(int _number);
	public List<Account> selectAccountByRealname(String _fname, String _lname);
	public List<Account> selectAccountBySSN(int _ssn);
	public List<Account> selectAllAccount();
	//UPDATE
	public int updateAccount(Account _account);
	//DELETE
	public int deleteAccount(Account _account);

}
