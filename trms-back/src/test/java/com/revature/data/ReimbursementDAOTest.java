package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.EventType;
import com.revature.beans.GradingFormat;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.utils.DAOFactory;

public class ReimbursementDaoTest {
	private ReimbursementDAO rd = DAOFactory.getReimbursementDAO();
	private EmployeeDAO ed = DAOFactory.getEmployeeDAO();

	@Test
	public void createTest() {
		GradingFormat gf = new GradingFormat();
		EventType et = new EventType();
		Status st = new Status();
		Reimbursement create = new Reimbursement();
		LocalDate day = LocalDate.of(2021, 01, 31);
		LocalTime time = LocalTime.of(8, 50);
		int one = 1;
		create.getRequestor().setEmpId(one);
		create.setEventDate(day);
		create.setEventTime(time);
		create.setGradingFormat(gf);
		create.setEventType(et);
		create.setStatus(st);
		assertNotEquals(0, rd.create(create));
	}

	@Test
	public void getByIdNotNull() {
		Reimbursement actual = rd.getById(1);
		assertNotEquals(null, actual);
	}

	@Test
	public void getByIdValidReimbursement() {
		String expected = "2021-07-18 03:44:44";
		Reimbursement one = rd.getById(4);
		LocalDate d = one.getEventDate();
		LocalTime t = one.getEventTime();
		d.toString();
		t.toString();
		String actual = d + " " + t;
		assertEquals(expected, actual);
	}

	@Test
	public void getAllNotNull() {
		Set<Reimbursement> actual = rd.getAll();
		assertNotEquals(null, actual);
	}

	@Test
	public void getByRequestorNotNull() {
		Employee expected = ed.getById(14);
		Set<Reimbursement> actual = rd.getByRequestor(expected);
		assertNotEquals(null, actual);
	}

	@Test
	public void getReimbursementByValidRequestor() {
		Employee expected = ed.getById(14);
		Set<Reimbursement> reqs = rd.getByRequestor(expected);
		Employee actual = new Employee();
		for (Reimbursement req : reqs) {
			actual = req.getRequestor();
		}

		assertEquals(expected.getEmpId(), actual.getEmpId());
	}

//	@Test
//	public void getReimbursementByInvalidRequestor()
//	{
//		Employee expected = ed.getById(9999);
//		Employee real = ed.getById(1);
//		Reimbursement req = rd.getByRequestor(real);
//		Employee actual = req.getRequestor();
//		assertNotEquals(expected, actual);
//	}
//

}
