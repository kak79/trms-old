package com.revature.data;

import java.util.Set;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.Status;

public interface ReimbursementDAO extends GenericDAO<Reimbursement> {
	public Set<Reimbursement> getByRequestor(Employee requestor);
	public Set<Reimbursement> getByStatus(Status status);
	public Set<Reimbursement> getPendByApprover(Employee approver, int s);
}
