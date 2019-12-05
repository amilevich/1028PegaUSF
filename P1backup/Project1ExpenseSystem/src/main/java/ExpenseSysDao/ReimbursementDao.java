package ExpenseSysDao;

import java.util.ArrayList;

import ExpenseSysModels.Reimbursement;

public interface ReimbursementDao {

	//CREATE
	public void insertReimb(Reimbursement r);
	
	//READ
	public Reimbursement selectReimbById(int id);
	public ArrayList<Reimbursement> selectAllReimb();
	public ArrayList<Reimbursement> selectAllEmpReimb(int id);
	
	//UPDATE
	public void updateReimb(Reimbursement r);
	
	//DELETE
	public void deleteReimb(Reimbursement r);
}
