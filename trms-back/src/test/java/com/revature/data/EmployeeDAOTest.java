package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.data.postgres.EmployeePostgres;
import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.utils.DAOFactory;

public class EmployeeDAOTest {
	private EmployeeDAO ed = DAOFactory.getEmployeeDAO();

	@BeforeEach
	public void setup() {
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
	public void getByIdNotNull() {
		Employee actual = ed.getById(1);
		assertNotEquals(null, actual);
	}

	@Test
	public void getByIdValidEmployee() {
		String expected = "emongan0";
		Employee one = ed.getById(2);
		String actual = one.getUsername();
		assertEquals(expected, actual);
	}

	@Test
	public void getAllNotNull() {
		Set<Employee> actual = ed.getAll();
		assertNotEquals(null, actual);
	}

	public void getByUsernameNotNull() {
		String expected = "emongan0";
		Employee emp = ed.getByUsername(expected);
		String actual = emp.getUsername();
		assertNotEquals(null, actual);
	}

	@Test
	public void getByUsernameValidEmployee() {
		String expected = "emongan0";
		Employee emp = ed.getByUsername(expected);
		String actual = emp.getUsername();
		assertEquals(expected, actual);
	}

	@Test
	public void getByUsernameInvalidEmployee() {
		String expected = "lksdjfoisd";
		String real = "emongan0";
		Employee emp = ed.getByUsername(real);
		String actual = emp.getUsername();
		assertNotEquals(expected, actual);
	}

}
