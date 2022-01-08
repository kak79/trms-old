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
		
		app.before("/requests/*", ctx -> {
			if (!ctx.method().equals("OPTIONS")) {
				ctx.header("Access-Control-Allow-Headers", "Token");
			    ctx.header("Access-Control-Expose-Headers", "Token");
				
				String token = ctx.header("Token");
				if (token==null) ctx.status(HttpCode.UNAUTHORIZED);
			}	
		});
		
		
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
			
			
			path("/requests", () -> {
				
				
				
				post(RequestsController::submitReimbursementRequest);
				
				
				
				path("/requestor/{id}", () -> {
					
					
					
					get(RequestsController::getRequestsByRequestor);
					
					
					
				});
			});
		});
	}

}


//app.before("/pets/*", ctx -> {
//	if (!ctx.method().equals("OPTIONS")) {
//		ctx.header("Access-Control-Allow-Headers", "Token");
//	    ctx.header("Access-Control-Expose-Headers", "Token");
//		
//		String token = ctx.header("Token");
//		if (token==null) ctx.status(HttpCode.UNAUTHORIZED);
//	}
//});
//
//app.routes(() -> {
//	// localhost:8080/pets
//	path("/pets", () -> {
//		get(PetsController::getPets);
//		post(PetsController::addPet);
//		
//		// localhost:8080/pets/adopt/8
//		path("/adopt/{id}", () -> {
//			put(PetsController::adoptPet);
//		});
//		
//		// localhost:8080/pets/8
//		path("/{id}", () -> {
//			get(PetsController::getPetById);
//			put(PetsController::updatePet);
//		});
//	});
//	
//	path("/users", () -> {
//		post(UsersController::register); // register
//		path("/auth", () -> {
//			post(UsersController::logIn); // login
//		});
//		path("/{id}", () -> {
//			get(UsersController::getUserById); // get user by id
//			put(UsersController::updateUser); // update user
//			path("/auth", () -> {
//				get(UsersController::checkLogin); // check login
//			});
//		});
//	});
//});
//}