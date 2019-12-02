package com.project.ReimDao;

import java.util.List;

import com.project.Reimburse.EmployeeUser;
import com.project.Reimburse.Reimburse;

public interface ReimburseDao {

	
	public int addNewTicket(Reimburse newTick);
	
	public EmployeeUser pullInfobyUsername(String user);
	
	public Reimburse getAllTickById (int userId);
	

	
	//For finance managers only
	//Pull accounts that are still pending
	public Reimburse pullAllPending(int getAll);
	
	public List<Reimburse> pullAllAccounts();
	
	
}
