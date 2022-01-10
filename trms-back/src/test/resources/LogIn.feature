Feature: Employee can Log In

  Scenario: Employee Logs in Correctly
    Given Employee is on the Home Page
    #And Employee exists in the DataBase
    And Employee enters the correct <username>
    And Employee enters the correct <password>
    When Employee clicks Submit to LogIn
    Then nav bar will display <username> 
    
    
        Examples: 
      | username 		  | password 	
      | vbriamo7 			|   pass 		
      |	jfaux2				|		pass				
      |	cgoranovi			|		pass		
      |	oommundsenx		|		pass		
    
    
 Scenario: Employee Logs in Incorrectly
    Given Employee is on the Home Page
    #And Employee exists in the DataBase
    And Employee enters the correct <username>
    And Employee enters the correct <password>
    When Employee clicks Submit to LogIn
    #Then Employee will not be Logged In
    Then Incorrect Credentials is displayed

        Examples: 
      | username 		  | password 	
      | kjdfheoiuhfo 	|   pass		
      |	oommundsenx		|		p4ss		
      |	cgoranovi			|		p3ss		
      | ewruifbeidcj 	|   pass		  
      
