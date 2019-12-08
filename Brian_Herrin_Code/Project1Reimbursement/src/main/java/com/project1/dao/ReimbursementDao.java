package com.project1.dao;

import java.util.List;

import com.project1.model.Reimbursement;

public interface ReimbursementDao {
	public int insertReimbursement(Reimbursement r);
	public void updateReimbursement(Reimbursement r);
	public void updateReimbursementReceipt(Reimbursement r);
	public void updateReimbursementResolved(Reimbursement r);
	public List<Reimbursement> selectReimbursementsByUsersId(int userId);
	void updateReimbursement(int id, int statid, int resolverid);
	public List<Reimbursement> selectReimbursementPending();
	public List<Reimbursement> selectAllReimbursements();
}
