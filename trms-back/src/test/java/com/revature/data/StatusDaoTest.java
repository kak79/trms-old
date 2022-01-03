package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Status;
import com.revature.data.postgres.StatusPostgres;
import com.revature.utils.DAOFactory;

public class StatusDaoTest {
	private StatusDAO sd = DAOFactory.getStatusDAO();
	
	
	@BeforeEach
	public void setup()
	{
		sd = new StatusPostgres();
	}
	
	@Test
	public void getByIdNotNull()
	{
		Status actual = sd.getById(1);
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByIdValidStatus()
	{
		String expected = "Pending Approval";
		Status one = sd.getById(1);
		String actual = one.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Status> actual = sd.getAll();
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByNameNotNull()
	{
		String name = "Pending Approval";
		Status actual = sd.getByName(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByNameValidStatus()
	{
		String expected = "Pending Approval";
		Status gf = sd.getByName(expected);
		String actual = gf.getName();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByNameInvalidStatus()
	{
		String expected = "PA";
		String real = "Pending Approval";
		Status gf = sd.getByName(real);
		String actual = gf.getName();
		assertNotEquals(expected, actual);
	}
		
	

}










//private EventTypeDAO eventTypeDao = DAOFactory.getEventTypeDAO();
//private GradingFormatDAO gradFormatDao = DAOFactory.getGradingFormatDAO();
//private StatusDAO statusDao = DAOFactory.getStatusDAO();
//private ReimbursementDAO reqDao = DAOFactory.getReimbursementDAO();
//private CommentDAO commentDao = DAOFactory.getCommentDAO();
//private EmployeeDAO empDao = DAOFactory.getEmployeeDAO();





