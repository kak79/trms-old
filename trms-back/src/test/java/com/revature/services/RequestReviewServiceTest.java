package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Comment;
import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.beans.EventType;
import com.revature.beans.GradingFormat;
import com.revature.beans.Reimbursement;
import com.revature.beans.Role;
import com.revature.beans.Status;
import com.revature.data.CommentDAO;
import com.revature.data.DepartmentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.EventTypeDAO;
import com.revature.data.GradingFormatDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;

@ExtendWith(MockitoExtension.class)
public class RequestReviewServiceTest {
	@Mock
	private CommentDAO cd;
	
	@Mock
	private DepartmentDAO dd;
	
	@Mock
	private EmployeeDAO ed;
	
	@Mock
	private EventTypeDAO etd;
	
	@Mock
	private GradingFormatDAO gfd;
	
	@Mock
	private ReimbursementDAO rd;
	
	@Mock
	private StatusDAO sd;
	
	@InjectMocks
	private RequestReviewService rrs = new ReqReviewServImp();
	
	
	private static Set<Employee> mockEmployees;
	private static Set<Reimbursement> mockRequests;
	private static Set<Reimbursement> mockPendReqs;
	private static Set<Comment> mockComments;
	private static Set<Status> mockStatus;
	private static Set<Role> mockRole;
	private static Set<Object> mockEventTypes;
	private static Set<Object> mockGradingFormats;
	
	static Status mockStts1 = new Status(1, "Pending Approval", "Supervisor");
	static Status mockStts2 = new Status(2, "Approved", "Supervisor");
	static Status mockStts3 = new Status(3, "Denied", "Supervisor");
	static Role mockRl1 = new Role(1, "User");
	static Role mockRl2 = new Role(2, "Supervisor");
	static EventType evntTp = new EventType(1, "University Course", 60.0);
	static GradingFormat grdFrmt = new GradingFormat(1, "Pass/Fail", "Pass");
	Department mockDpt = new Department(1, "Test Department", 24);
	
	@BeforeAll
	public static void mockEventTypes() {
		mockEventTypes = new HashSet<>();
		mockEventTypes.add(evntTp);
	}
	
	@BeforeAll
	public static void mockGradingFormats() {
		mockGradingFormats = new HashSet<>();
		mockGradingFormats.add(grdFrmt);
	}
	
	@BeforeAll
	public static void mockStatusSetup() {
		mockStatus = new HashSet<>();
		
		mockStatus.add(mockStts1);
		mockStatus.add(mockStts2);
		mockStatus.add(mockStts3);
	}
	
	@BeforeAll
	public static void mockRoleSetup() {
		mockRole = new HashSet<>();
		
		mockRole.add(mockRl1);
		mockRole.add(mockRl2);
	}
	
	@BeforeAll
	public static void mockRequestsSetup() {
		mockRequests = new HashSet<>();
		
		for (int i=1; i<=8; i++) {
			Reimbursement req = new Reimbursement();
			req.setReqId(i);
			req.getRequestor().setEmpId(10);
			for (int j=1; j<=3; j++) {
				req.getStatus().setStatusId(j);
			}
			mockRequests.add(req);
		}
	}
	
	@BeforeAll
	public static void mockPendReqsSetup() {
		mockPendReqs = new HashSet<>();
		
		for (int i=1; i<=8; i++) {
			Reimbursement req = new Reimbursement();
			req.setReqId(i);
			req.getRequestor().setEmpId(10);
			req.getStatus().setStatusId(1);
			mockPendReqs.add(req);
		}
	}
	
	@BeforeAll
	public static void mockCommentsSetup() {
		mockComments = new HashSet<>();
		
		for (int i=1; i<=24; i++) {
			Comment com = new Comment();
			com.setCommentId(i);
			for (int j=1; i<=3; i++) {
				com.setRequest(new Reimbursement());
				com.getRequest().setReqId(j);
				com.setApprover(new Employee());
				if(i==1) com.getApprover().setEmpId(1);
				else com.getApprover().setEmpId(24);
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
			if(i==24) emp.getRole().setRoleId(2);
			else emp.getRole().setRoleId(1);
			mockEmployees.add(emp);	
		}
	}
	
	@Test
	public void getPendReqsSup() {
		Employee emp = new Employee();
		Role role = new Role();
		role.setRoleId(2);
		emp.setRole(role);
		
		Status status = new Status();
		status.setStatusId(1);
		
		when(rd.getByStatus(status)).thenReturn(mockPendReqs);
		
		Set<Reimbursement> acutalReqs = rd.getByStatus(status);
		
		assertEquals(mockPendReqs,acutalReqs);
	}
	
	@Test
	public void getPendReqsMngr() {
		Employee emp = new Employee();
		Role role = new Role();
		role.setRoleId(3);
		emp.setRole(role);
		
		Status status = new Status();
		status.setStatusId(1);
		
		when(rd.getByStatus(status)).thenReturn(mockPendReqs);
		
		Set<Reimbursement> acutalReqs = rd.getByStatus(status);
		
		assertEquals(mockPendReqs,acutalReqs);
	}
	
	@Test
	public void getPendReqsBenco() {
		Employee emp = new Employee();
		Role role = new Role();
		role.setRoleId(4);
		emp.setRole(role);
		
		Status status = new Status();
		status.setStatusId(1);
		
		when(rd.getByStatus(status)).thenReturn(mockPendReqs);
		
		Set<Reimbursement> acutalReqs = rd.getByStatus(status);
		
		assertEquals(mockPendReqs,acutalReqs);
	}
	
	@Test
	public void successfullyApproveReq() {
		
	}
	
	@Test
	public void unsuccessfullyApproveReq() {
		
	}
	
	@Test
	public void successfullyDenyReq() {
		
	}
	
	@Test
	public void unsuccessfullyDenyReq() {
		
	}

}
