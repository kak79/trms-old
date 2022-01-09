package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

import static io.javalin.apibuilder.ApiBuilder.*;

import com.revature.controllers.*;

public class TRMSApp {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
		});
		
		app.start();
		
//		app.before("/reqs/*", ctx -> {
//			if (!ctx.method().equals("OPTIONS")) {
//				ctx.header("Access-Control-Allow-Headers", "Token");
//			    ctx.header("Access-Control-Expose-Headers", "Token");
//				
//				String token = ctx.header("Token");
//				if (token==null) ctx.status(HttpCode.UNAUTHORIZED);
//			}	
//		});
	
		app.routes(() -> {
			
			path("/employees", () -> {
				
				path("/auth", () -> {
					post(EmployeeController::logIn); // login
				});
				path("/{id}", () -> {
					get(EmployeeController::getEmpById); // get user by id
					path("/auth", () -> {
						get(EmployeeController::checkLogin); // check login
					});
				});
			});
		
			path("/reqs", () -> {
				
				get(RequestsController::getAllReqs);
				post(RequestsController::submitReimbursementRequest);

				path("/requestor/{id}", () -> {
					get(RequestsController::getRequestsByRequestor);
				});	
				path("/approver/{id}", () -> {
					get(RequestsController::getRequestsByApprover);
					put(RequestsController::updateARequest);
					
				});
			});
		});
	}

}

