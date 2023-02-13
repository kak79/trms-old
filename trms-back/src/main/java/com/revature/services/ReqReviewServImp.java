package com.revature.services;

import java.util.Set;

import com.revature.data.ReimbursementDAO;
import com.revature.models.Comment;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.utils.DAOFactory;

public class ReqReviewServImp implements RequestReviewService {
	private ReimbursementDAO rd = DAOFactory.getReimbursementDAO();

	@Override
	public Set<Reimbursement> getPendingReimbursements(Employee approver, int s) {
		return rd.getPendByApprover(approver, s);
	}

	@Override
	public void approveRequest(Reimbursement request) {
		Status s = new Status();
		request.setStatus(s);
		rd.update(request);
	}

	@Override
	public void rejectRequest(Reimbursement request) {
		Status s = new Status();
		request.setStatus(s);
		rd.update(request);
	}

	@Override
	public void rejectRequest(Reimbursement request, Comment comment) {
		// TODO Auto-generated method stub

	}

}
