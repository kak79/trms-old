package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.postgres.ReimbursementPostgres;

public class ReimbursementDaoTest {
	private ReimbursementDAO rd = new ReimbursementPostgres();
	
//	@Test
//	public void createTest() {
//		Department it = new Department(1, "IT", 34);
//		Employee create = new Employee();
//		create.setDepartment(it);
//		Employee sup = new Employee(34);
//		create.setSupervisor(sup);
//		assertNotEquals(0, ed.create(create));
//	}
	
	
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
		String name = "emongan0";
		Reimbursement actual = rd.getByRequestor(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByRequestorValidReimbursement()
	{
		String expected = "emongan0";
		Reimbursement req = rd.getByRequestor(expected);
		String actual = req.getRequestor();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByRequestorInvalidReimbursement()
	{
		String expected = "lksdjfoisd";
		String real = "emongan0";
		Reimbursement req = rd.getByRequestor(real);
		String actual = req.getRequestor();
		assertNotEquals(expected, actual);
	}
	
	

}
