package com.project1.dao;

import com.project1.model.Reimbursement;

public interface ReimbursementDao {
	public int insertReimbursement(Reimbursement r);
	public Reimbursement selectReimbursementByName(String name);
	public void updateReimbursement(Reimbursement r);
	
}
