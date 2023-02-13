package com.revature.controllers;

import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;

import com.revature.data.EmployeeDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.ReqReviewServImp;
import com.revature.services.RequestReviewService;
import com.revature.utils.DAOFactory;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {
	private static ReimbursementDAO rd = DAOFactory.getReimbursementDAO();
	private static EmployeeDAO ed = DAOFactory.getEmployeeDAO();
	private static RequestReviewService rs = new ReqReviewServImp();
	private static EmployeeService es = new EmployeeServiceImpl();
	private static Employee emp = new Employee();
	private static Reimbursement req = new Reimbursement();
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(EmployeeController.class);
	
	public static void getAllEmps(Context ctx) {
		
		Set<Employee> emps = ed.getAll();
		log.info("getting all of the employees");
		ctx.json(emps);
	}
	public static void viewEmployeeById(Context ctx) {
		
		int id = Integer.parseInt(ctx.pathParam("empId"));
		log.info("getting employee by id: "+id);
		try {
			
			emp = ed.getById(id);
			if (id != 0) {
				ctx.json(emp);
			} else {
				ctx.status(404);
				ctx.result("The employee does not exist.");
			}
		} catch (NumberFormatException e) {
			ctx.status(400);
			ctx.result("Employee ID must be an integer. Please try again.");
		}
		
		}
	
	
	
	
	public static void logIn(Context ctx) {
		Map<String,String> creds = ctx.bodyAsClass(Map.class);
		String username = creds.get("username");
		String password = creds.get("password");
		
		try {
			Employee emp = es.logIn(username, password);
			String token = Integer.toString(emp.getEmpId());
			ctx.result(token);
		} catch (Exception e) {//IncorrectCredentialsException e) {
			ctx.status(404);
			ctx.result(e.getMessage());
		}
	}
	public static void checkLogin(Context ctx) {
		//String token = ctx.body();
		try {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Employee loggedInEmp = es.getEmployeeById(id);
			if (loggedInEmp!=null) {
				ctx.json(loggedInEmp);
			} else {
				ctx.status(HttpCode.UNAUTHORIZED);
			}
		} catch (NumberFormatException e) {
			ctx.status(400);
			ctx.result("User ID and token must be numeric values");
		}
	}
	
	public static void getEmpById(Context ctx) {
		try {
			int empId = Integer.parseInt(ctx.pathParam("id")); // num format exception
			Employee emp = es.getEmployeeById(empId);
			if (emp != null)
				ctx.json(emp);
			else
				ctx.status(404);
		} catch (NumberFormatException e) {
			ctx.status(400);
			ctx.result("Employee ID must be a numeric value");
		}
	}
	
	
	
}
