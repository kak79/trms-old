package com.revature.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.EventTypeDAO;
import com.revature.data.GradingFormatDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;
import com.revature.exceptions.WrongUsrnmPsswrdException;
import com.revature.utils.DAOFactory;

public class EmployeeServiceImpl implements EmployeeService {
	private CommentDAO cd = DAOFactory.getCommentDAO();
	private EmployeeDAO ed = DAOFactory.getEmployeeDAO();
	private EventTypeDAO etd = DAOFactory.getEventTypeDAO();
	private GradingFormatDAO gfd = DAOFactory.getGradingFormatDAO();
	private ReimbursementDAO rd = DAOFactory.getReimbursementDAO();
	private StatusDAO sd = DAOFactory.getStatusDAO();

	@Override
	public Employee logIn(String username, String password) throws WrongUsrnmPsswrdException{
		Employee emp = ed.getByUsername(username);
		if (emp != null && emp.getPassword().equals(password)) {
			return emp;
		} else {
			throw new WrongUsrnmPsswrdException();
		}
	}
	
	@Override
	public Map<String, Set<Object>> getRequestOptions() {
		Map<String,Set<Object>> requestOptions = new HashMap<>();
		requestOptions.put("eventTypes", etd.getAll());
		requestOptions.put("gradingFormats", gfd.getAll());
		return requestOptions;
	}

	@Override
	public int submitReimbursementRequest(Reimbursement request) {
		Status initialStatus;
		if (request.getRequestor().getRole().getRoleId()==1) {
			initialStatus = sd.getById(1);
		} else if (request.getRequestor().getRole().getRoleId()==2 || 
				request.getRequestor().getRole().getRoleId()==4) {
			initialStatus = sd.getById(4);
		} else {
			initialStatus = sd.getById(7);
		}
		request.setStatus(initialStatus);
		request.setSubmittedAt(LocalDateTime.now());
		return rd.create(request);
	}

	@Override
	public Set<Reimbursement> getReimbursementRequests(Employee requestor) {
		Set<Reimbursement> requests = rd.getByRequestor(requestor);
		requests.forEach(req -> {
			req.setRequestor(requestor);
		});
		return requests; 
	}

	@Override
	public Set<Comment> getComments(Reimbursement request) {
		Set<Comment> comments = cd.getByRequestId(request.getReqId());
		comments.forEach(comment -> {
			comment.setApprover(ed.getById(comment.getApprover().getEmpId()));
			comment.setRequest(request);
		});
		return comments;
	}

	@Override
	public int addComment(Comment comment) {
		comment.setSentAt(LocalDateTime.now());
		return cd.create(comment);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return ed.getById(empId);
	}

}
