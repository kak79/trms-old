package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Map;
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
import com.revature.exceptions.WrongUsrnmPsswrdException;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

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
	private EmployeeService es = new EmployeeServiceImpl();

	private static Set<Employee> mockEmployees;
	private static Set<Reimbursement> mockRequests;
	private static Set<Comment> mockComments;
	private static Set<Comment> mockCommentsWhereReqIs3;
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

		for (int i = 1; i <= 8; i++) {
			Reimbursement req = new Reimbursement();
			req.setReqId(i);
			req.getRequestor().setEmpId(10);
			for (int j = 1; j <= 3; j++) {
				req.getStatus().setStatusId(j);
			}
			mockRequests.add(req);
		}
	}

	@BeforeAll
	public static void mockCommentsSetup() {
		mockComments = new HashSet<>();
		mockCommentsWhereReqIs3 = new HashSet<>();

		for (int i = 1; i <= 24; i++) {
			Comment com = new Comment();
			com.setCommentId(i);
			for (int j = 1; j <= 8; j++) {
				com.setRequest(new Reimbursement());
				com.getRequest().setReqId(j);
			}
			com.setApprover(new Employee());
			com.getApprover().setEmpId(24);
			mockComments.add(com);
			if (com.getRequest().getReqId() == 3) {
				mockCommentsWhereReqIs3.add(com);
			}
		}
	}

	@BeforeAll
	public static void mockEmployeesSetup() {
		mockEmployees = new HashSet<>();

		for (int i = 1; i <= 24; i++) {
			Employee emp = new Employee();
			emp.setEmpId(i);
			emp.setFirstName("Test" + i);
			emp.setLastName("Test" + i);
			emp.setUsername("test" + i);
			emp.setPassword("pass");
			emp.setFunds(1000.00);
			emp.getSupervisor().setEmpId(24);
			if (i == 24)
				emp.getRole().setRoleId(2);
			else
				emp.getRole().setRoleId(1);
			mockEmployees.add(emp);
		}
	}

	@Test
	public void logInSuccessfully() throws WrongUsrnmPsswrdException {
		Employee mockEmp = new Employee();
		mockEmp.setEmpId(1);
		String username = mockEmp.getUsername();
		String password = mockEmp.getPassword();

		when(ed.getByUsername(username)).thenReturn(mockEmp);

		Employee realEmp = es.logIn(username, password);

		assertEquals(mockEmp, realEmp);
	}

	@Test
	public void logInIcorrectPassword() throws WrongUsrnmPsswrdException {
		Employee mockEmp = new Employee();
		mockEmp.setEmpId(1);
		String username = mockEmp.getUsername();
		String password = "lskdfj";
		mockEmp.getPassword();

		when(ed.getByUsername(username)).thenReturn(mockEmp);

		assertThrows(WrongUsrnmPsswrdException.class, () -> {
			es.logIn(username, password);
		});
	}

	@Test
	public void logInUsernameDoesNotExist() throws WrongUsrnmPsswrdException {
		String username = "lsdifu";
		String password = "pass";

		when(ed.getByUsername(username)).thenReturn(null);

		assertThrows(WrongUsrnmPsswrdException.class, () -> {
			es.logIn(username, password);
		});
	}

	@Test
	public void getRequestOptionsSuccessfully() {

		when(etd.getAll()).thenReturn(mockEventTypes);
		when(gfd.getAll()).thenReturn(mockGradingFormats);
		Map<String, Set<Object>> actualRequestOptions = es.getRequestOptions();
		assertNotNull(actualRequestOptions);

	}

	@Test
	public void submitUnsuccessfulReimbursementRequest() {
		Reimbursement req = new Reimbursement();

		when(rd.create(req)).thenReturn(0);

		int newId = es.submitReimbursementRequest(req);

		assertEquals(0, newId);
	}

	@Test
	public void submitSuccessfulReimbursementRequest() {
		Reimbursement req = new Reimbursement();

		when(rd.create(req)).thenReturn(2);

		int newId = es.submitReimbursementRequest(req);

		assertNotEquals(0, newId);
	}

	@Test
	public void successfullyGetReimbursementReguests() {
		Employee emp = new Employee();
		emp.setEmpId(10);

		when(rd.getByRequestor(emp)).thenReturn(mockRequests);

		Set<Reimbursement> reqs = es.getReimbursementRequests(emp);

		assertEquals(mockRequests, reqs);
	}

	@Test
	public void unsuccessfullyGetReimbursementReguests() {
		Employee one = new Employee();
		one.setEmpId(1);

		Set<Reimbursement> reqs = es.getReimbursementRequests(one);

		assertTrue(reqs.isEmpty());
	}

	@Test
	public void successfullyGetCommentsForAReimbursementRequest() {
		Reimbursement req = new Reimbursement();
		req.setReqId(3);

		when(cd.getByRequestId(3)).thenReturn(mockCommentsWhereReqIs3);

		Set<Comment> com = es.getComments(req);

		assertEquals(mockCommentsWhereReqIs3, com);
	}

	@Test
	public void unsuccessfullyGetCommentsForAReimbursementRequest() {
		Reimbursement req = new Reimbursement();
		req.setReqId(1);

		Set<Comment> com = es.getComments(req);

		assertTrue(com.isEmpty());
	}

	@Test
	public void successfullyAddANewComment() {
		Comment com = new Comment();

		when(cd.create(com)).thenReturn(3);

		int newId = es.addComment(com);

		assertEquals(3, newId);
	}

	@Test
	public void unsuccessfullyAddANewComment() {
		Comment com = new Comment();

		when(cd.create(com)).thenReturn(0);

		int newId = es.addComment(com);

		assertEquals(0, newId);
	}

	@Test
	public void successfullyGetEmployeeById() {
		Employee emp = new Employee();
		emp.setEmpId(2);

		when(ed.getById(2)).thenReturn(emp);
		Employee actualEmp = es.getEmployeeById(2);
		assertEquals(emp, actualEmp);
	}

	@Test
	public void unsuccessfullyGetEmployeeById() {
		when(ed.getById(2)).thenReturn(null);

		Employee actualEmp = es.getEmployeeById(2);
		assertNull(actualEmp);
	}

}
