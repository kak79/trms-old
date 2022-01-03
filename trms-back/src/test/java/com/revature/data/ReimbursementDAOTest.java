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
import com.revature.utils.DAOFactory;

public class ReimbursementDaoTest {
	private ReimbursementDAO rd = DAOFactory.getReimbursementDAO();
//	private EmployeeDAO ed = new EmployeePostgres();
	
	@Test   
	public void createTest() {
		GradingFormat gf = new GradingFormat();
		EventType et = new EventType();
		Status st = new Status();
		Reimbursement create = new Reimbursement();
		int one = 1;
		
		create.getRequestor().setEmpId(one);
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
		String expected = "jfaux2";
		Reimbursement one = rd.getById(4);
		System.out.println(one);
		String actual = one.getRequestor().getUsername();
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Reimbursement> actual = rd.getAll();
		assertNotEquals(null, actual);
	}
	
//	public void getByRequestorNotNull()
//	{
//		Employee expected = ed.getById(1);
//		Reimbursement actual = rd.getByRequestor(expected);
//		assertNotEquals(null, actual);
//	}
//	
//	
//	@Test
//	public void getReimbursementByValidRequestor()
//	{
//		Employee expected = ed.getById(1);
//		Reimbursement req = rd.getByRequestor(expected);
//		Employee actual = req.getRequestor();
//		assertEquals(expected, actual);
//	}
//	
//	
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















