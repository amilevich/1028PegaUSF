package part2;

import java.util.ArrayList;

public interface AccountDao {

	//CREATE
	public void insertAcct(Client c);
	
	//READ
	public Account selectAcctByNum(int num);
	public ArrayList<Account> selectAllAccts();
	
	//UPDATE
	public void updateAcct(Account a);
	
	//DELETE
	public void deleteAcct(Account a);

	ArrayList<Account> selectClientAccts(String un);
	
}
