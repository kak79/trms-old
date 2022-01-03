package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.beans.Comment;
import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.CommentDAO;
import com.revature.data.DepartmentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.EventTypeDAO;
import com.revature.data.GradingFormatDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;
import com.revature.utils.DAOFactory;

public class EmployeeServiceTest {

	@Mock
	private CommentDAO cd = DAOFactory.getCommentDAO();
	
	@Mock
	private DepartmentDAO dd = DAOFactory.getDepartmentDAO();
	
	@Mock
	private EmployeeDAO ed = DAOFactory.getEmployeeDAO();
	
	@Mock
	private EventTypeDAO etd = DAOFactory.getEventTypeDAO();
	
	@Mock
	private GradingFormatDAO gfd = DAOFactory.getGradingFormatDAO();
	
	@Mock
	private ReimbursementDAO rd = DAOFactory.getReimbursementDAO();
	
	@Mock
	private StatusDAO sd = DAOFactory.getStatusDAO();
	
	@InjectMocks
	private EmployeeService es = new EmployeeServiceImpl();
	
	
	private static Set<Employee> mockEmployees;
	private static Set<Reimbursement> mockRequests;
	private static Set<Comment> mockComments;
	private static Set<Department> mockDepartments;
	
	Department mockDpt = new Department(1, "Test Department", 24);
	
	@BeforeAll
	public static void mockRequestsSetup() {
		mockRequests = new HashSet<>();
		
		for (int i=1; i<=8; i++) {
			Reimbursement req = new Reimbursement();
			req.setReqId(i);
			req.getRequestor().setEmpId(10);
			req.getStatus().setStatusId(i);
			mockRequests.add(req);
		}
	}
	
	@BeforeAll
	public static void mockCommentsSetup() {
		mockComments = new HashSet<>();
		
		for (int i=1; i<=24; i++) {
			Comment com = new Comment();
			com.setCommentId(i);
			for (int j=1; i<=8; i++) {
				com.getRequest().setReqId(j);
				if(i<3) com.getApprover().setEmpId(1);
				else if(i<5) com.getApprover().setEmpId(18);
				else com.getApprover().setEmpId(44);
			}
			mockComments.add(com);
		}
	}
	
	@BeforeAll
	public static void mockEmployeesSetup() {
		mockEmployees = new HashSet<>();
		
		for (int i=1; i<=24; i++) {
			Employee emp = new Employee();
			emp.setEmpId(i);
			emp.setFirstName("Test"+i);
			emp.setLastName("Test"+i);
			emp.setUsername("test" + i);
			emp.setPassword("pass");
			emp.setFunds(1000.00);
			emp.getSupervisor().setEmpId(24);
			
			if(i==24) emp.getRole().setRoleId(3);
			else if(i==23) emp.getRole().setRoleId(2);
			else emp.getRole().setRoleId(1);
			
			mockEmployees.add(emp);		
	}
	
	
	
	
	
	
	
	
}













