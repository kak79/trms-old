package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.postgres.CommentPostgres;
import com.revature.utils.DAOFactory;

public class CommentDaoTest {
	private CommentDAO cd = DAOFactory.getCommentDAO();

	@BeforeEach
	public void setup() {
		cd = new CommentPostgres();
	}

	@Test
	public void createTest() {
		Comment create = new Comment();
		Reimbursement request = new Reimbursement(1);
		create.setRequest(request);
		Employee approver = new Employee(34);
		create.setApprover(approver);
		assertNotEquals(0, cd.create(create));
	}

	@Test
	public void getByIdNotNull() {
		Comment actual = cd.getById(1);
		assertNotEquals(null, actual);
	}

	@Test
	public void getByIdValidComment() {
		String expected = "Pending Approval";
		Comment one = cd.getById(1);
		String actual = one.getCommentText();
		assertEquals(expected, actual);
	}

	@Test
	public void getAllNotNull() {
		Set<Comment> actual = cd.getAll();
		assertNotEquals(null, actual);
	}

	@Test
	public void getByReqIdNotNull() {
		Set<Comment> actual = cd.getByRequestId(1);
		assertNotEquals(null, actual);
	}

}
