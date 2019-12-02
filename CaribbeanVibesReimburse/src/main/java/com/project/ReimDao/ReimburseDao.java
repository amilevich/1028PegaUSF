package com.project.ReimDao;

import java.util.List;

import com.project.Reimburse.EmployeeUser;
import com.project.Reimburse.Reimburse;

public interface ReimburseDao {

	
	public int addNewTicket(Reimburse newTick);
	
	public EmployeeUser pullInfobyUsername(String user);
	
	public Reimburse getAllTickById (int userId);
	
	public String pullByRoleName (int roleId);
	
	public String pullStatusName(int statId);
	
	public String PullReimType(int reimId);
	
	//For finance managers only
	//Pull accounts that are still pending
	//public List<Reimburse> pullAllPendingReimburse();
	
	public List<Reimburse> pullAllAccounts();

	public int UpdateInfo(int userId,int fUserId,int RemiNum);
	
	
}
