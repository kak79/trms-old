package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.EventType;
import com.revature.data.postgres.EventTypePostgres;

public class EventTypeDaoTest {
	private EventTypeDAO etd = new EventTypePostgres();
	
	@BeforeEach
	public void setup()
	{
		etd = new EventTypePostgres();
	}
	
	@Test
	public void getByIdNotNull()
	{
		EventType actual = etd.getById(1);
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByIdValidEventType()
	{
		String expected = "University Course";
		EventType one = etd.getById(1);
		String actual = one.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<EventType> actual = etd.getAll();
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByNameNotNull()
	{
		String name = "Certification";
		EventType actual = etd.getByName(name);
		assertNotEquals(null, actual);
	}
	
	
	@Test
	public void getByNameValidEventType()
	{
		String expected = "Certification";
		EventType et = etd.getByName(expected);
		String actual = et.getName();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void getByNameInvalidEventType()
	{
		String expected = "Certs";
		String real = "Certification";
		EventType et = etd.getByName(real);
		String actual = et.getName();
		assertNotEquals(expected, actual);
	}
	
	

}
