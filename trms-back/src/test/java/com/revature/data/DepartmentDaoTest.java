package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Department;
import com.revature.data.postgres.DepartmentPostgres;

public class DepartmentDaoTest {
	private DepartmentDAO dd = new DepartmentPostgres();
	
	
	@BeforeEach
	public void setup()
	{
		dd = new DepartmentPostgres();
	}
	
	@Test
	public void getByIdNotNull()
	{
		Department actual = dd.getById(1);
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByIdValidDepartment()
	{
		String expected = "IT";
		Department one = dd.getById(1);
		String actual = one.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Department> actual = dd.getAll();
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByNameNotNull()
	{
		String name = "Training";
		Department actual = dd.getByName(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByNameValidDepartment()
	{
		String expected = "Research and Development";
		Department department = dd.getByName(expected);
		String actual = department.getName();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByNameInvalidDepartment()
	{
		String expected = "R&D";
		String real = "Research and Development";
		Department department = dd.getByName(real);
		String actual = department.getName();
		assertNotEquals(expected, actual);
	}
	
	
	
}
