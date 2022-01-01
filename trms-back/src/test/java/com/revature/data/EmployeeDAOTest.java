package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.data.postgres.EmployeePostgres;

public class EmployeeDaoTest
{
	private EmployeeDAO ed = new EmployeePostgres();
	
	@BeforeEach
	public void setup()
	{
		ed = new EmployeePostgres();
	}
	
	
	@Test
	public void createTest() {
		Department it = new Department(1, "IT", 34);
		Employee create = new Employee();
		create.setDepartment(it);
		Employee sup = new Employee(34);
		create.setSupervisor(sup);
		assertNotEquals(0, ed.create(create));
	}
	
	
	@Test
	public void getByIdNotNull()
	{
		Employee actual = ed.getById(1);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByIdValidEmployee()
	{
		String expected = "emongan0";
		Employee one = ed.getById(1);
		String actual = one.getUsername();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Employee> actual = ed.getAll();
		assertNotEquals(null, actual);
	}
	
	public void getByUsernameNotNull()
	{
		String name = "emongan0";
		Employee actual = ed.getByUsername(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByUsernameValidEmployee()
	{
		String expected = "emongan0";
		Employee emp = ed.getByUsername(expected);
		String actual = emp.getUsername();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByUsernameInvalidEmployee()
	{
		String expected = "lksdjfoisd";
		String real = "emongan0";
		Employee emp = ed.getByUsername(real);
		String actual = emp.getUsername();
		assertNotEquals(expected, actual);
	}
	
}

