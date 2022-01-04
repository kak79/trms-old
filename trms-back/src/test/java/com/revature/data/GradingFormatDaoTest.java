package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.GradingFormat;
import com.revature.data.postgres.GradingFormatPostgres;
import com.revature.utils.DAOFactory;

public class GradingFormatDaoTest {
	private GradingFormatDAO gfd = DAOFactory.getGradingFormatDAO();
	
	@BeforeEach
	public void setup()
	{
		gfd = new GradingFormatPostgres();
	}
	
	@Test
	public void getByIdNotNull()
	{
		GradingFormat actual = gfd.getById(1);
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByIdValidGradingFormat()
	{
		String expected = "Pass/Fail";
		GradingFormat one = gfd.getById(1);
		String actual = one.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Object> actual = gfd.getAll();
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByNameNotNull()
	{
		String name = "Pass/Fail";
		GradingFormat actual = gfd.getByName(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByNameValidGradingFormat()
	{
		String expected = "Pass/Fail";
		GradingFormat gf = gfd.getByName(expected);
		String actual = gf.getName();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByNameInvalidGradingFormat()
	{
		String expected = "P/F";
		String real = "Pass/Fail";
		GradingFormat gf = gfd.getByName(real);
		String actual = gf.getName();
		assertNotEquals(expected, actual);
	}
	
	

}











