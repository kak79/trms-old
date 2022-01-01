package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Comment;
import com.revature.data.postgres.CommentPostgres;

public class CommentDaoTest {
	private CommentDAO cd = new CommentPostgres();
	
	@BeforeEach
	public void setup()
	{
		cd = new CommentPostgres();
	}
	
	@Test
	public void getByIdNotNull()
	{
		Comment actual = cd.getById(1);
		assertNotEquals(null, actual);
	}
	
	@Test
	public void getByIdValidComment()
	{
		String expected = "Polarised methodical access";
		Comment one = cd.getById(1);
		String actual = one.getCommentText();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllNotNull()
	{
		Set<Comment> actual = cd.getAll();
		

		
		assertNotEquals(null, actual);
	}
	
}
