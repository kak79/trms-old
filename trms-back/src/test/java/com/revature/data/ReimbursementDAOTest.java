package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.EventType;
import com.revature.beans.GradingFormat;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.postgres.EmployeePostgres;
import com.revature.data.postgres.ReimbursementPostgres;

public class ReimbursementDaoTest {
	private ReimbursementDAO rd = new ReimbursementPostgres();
	private EmployeeDAO ed = new EmployeePostgres();
	
	@Test   
	public void createTest() {
		GradingFormat gf = new GradingFormat();
		EventType et = new EventType();
		Status st = new Status();
		Reimbursement create = new Reimbursement();
		Employee emp = new Employee();
		emp.setEmpId(1);
		create.setRequestor(emp);
		create.setGradingFormat(gf);
		create.setEventType(et);
		create.setStatus(st);
		System.out.println(create);
		assertNotEquals(0, rd.create(create));
	}
	
	
	@Test
	public void getByIdNotNull()
	{
		Reimbursement actual = rd.getById(1);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByIdValidReimbursement()
	{
		String expected = "emongan0";
		Reimbursement one = rd.getById(1);
		String actual = one.getRequestor().getUsername();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Reimbursement> actual = rd.getAll();
		assertNotEquals(null, actual);
	}
	
	public void getByRequestorNotNull()
	{
		Employee expected = ed.getById(1);
		Reimbursement actual = rd.getByRequestor(expected);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getReimbursementByValidRequestor()
	{
		Employee expected = ed.getById(1);
		Reimbursement req = rd.getByRequestor(expected);
		Employee actual = req.getRequestor();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getReimbursementByInvalidRequestor()
	{
		Employee expected = ed.getById(9999);
		Employee real = ed.getById(1);
		Reimbursement req = rd.getByRequestor(real);
		Employee actual = req.getRequestor();
		assertNotEquals(expected, actual);
	}
	
	
	
	

}
