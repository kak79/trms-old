

INSERT INTO user_role
(role_name)
VALUES
('User'),
('Supervisor'),
('Department Manager'),
('Benefits Coordinator');


INSERT INTO employee 
(first_name, last_name, username, passwd, role_id, funds, supervisor_id, dept_id) 
VALUES 
('Enrico', 'Mongan', 'emongan0', 'pass', 3, 1000.00, 1, 2),
('Joline', 'Northley', 'jnorthley1', 'pass',1, 1000.00, 8, 3),
('Jaime', 'Faux', 'jfaux2', 'pass', 2, 1000.00, 49, 5),
('Torin', 'Laguerre', 'tlaguerre3', 'pass', 3, 1000.00, 4, 4),
('Julianne', 'Leith-Harvey', 'jleithharvey4', 'pass', 1, 1000.00, 8, 3),
('Kathryne', 'De Cruze', 'kdecruze5', 'pass', 1, 1000.00, 8, 3),
('Zarla', 'Olphert', 'zolphert6', 'pass', 1, 1000.00, 8, 3),
('Valentine', 'Briamo', 'vbriamo7', 'pass', 2, 1000.00, 17, 3),
('Ula', 'Ladson', 'uladson8', 'pass', 1, 1000.00, 8, 3),
('Kimberli', 'Conibear', 'kconibear9', 'pass', 2, 1000.00, 1, 2),
('Quinn', 'Ottosen', 'qottosena', 'pass', 1, 1000.00, 8, 3),
('Yard', 'Riveles', 'yrivelesb', 'pass', 1, 1000.00, 8, 3),
('Jessalyn', 'Fookes', 'jfookesc', 'pass', 1, 1000.00, 8, 3),
('Ashli', 'Bothie', 'abothied', 'pass', 1, 1000.00, 8, 3), 
('Mehetabel', 'Brisse', 'mbrissee', 'pass', 1, 1000.00, 8, 3),
('Abby', 'Hinckley', 'ahinckleyf', 'pass', 1, 1000.00, 8, 3),
('Xylina', 'Kellock', 'xkellockg', 'pass', 3, 1000.00, 17, 3),
('Ivett', 'Gorriessen', 'igorriessenh', 'pass', 1, 1000.00, 8, 3),
('Chuck', 'Goranov', 'cgoranovi', 'pass', 1, 1000.00, 8, 3),
('Editha', 'Hymus', 'ehymusj', 'pass', 2, 1000.00, 34, 1),
('Renelle', 'Standidge', 'rstandidgek', 'pass', 1, 1000.00, 8, 3),
('Arlana', 'Kermon', 'akermonl', 'pass', 1, 1000.00, 3, 5),
('Andreas', 'Winspar', 'awinsparm', 'pass', 1, 1000.00, 10, 2),
('Phelia', 'O''Canavan', 'pocanavann', 'pass', 1, 1000.00, 8, 3),
('Noel', 'Hawsby', 'nhawsbyo', 'pass', 1, 1000.00, 10, 2),
('Fernandina', 'McLaren', 'fmclarenp', 'pass', 1, 1000.00, 8, 3),
('Cornelius', 'Bowcock', 'cbowcockq', 'pass', 1, 1000.00, 48, 4),
('Vasilis', 'McFfaden', 'vmcffadenr', 'pass', 1, 1000.00, 10, 2),
('Rhona', 'Phil', 'rphils', 'pass', 1, 1000.00, 8, 3), 
('Gilles', 'Hallgarth', 'ghallgartht', 'pass', 1, 1000.00, 8, 3),
('Layla', 'Paur', 'lpauru', 'pass', 1, 1000.00, 8, 3),
('Roberto', 'Hitchens', 'rhitchensv', 'pass', 1, 1000.00, 10, 2),
('Mauricio', 'Kohneke', 'mkohnekew', 'pass', 1, 1000.00, 8, 3), 
('Otto', 'Ommundsen', 'oommundsenx', 'pass', 3, 1000.00, 34, 1),
('Kial', 'Late', 'klatey', 'pass', 1, 1000.00, 8, 3), 
('Tripp', 'Umney', 'tumneyz', 'pass', 1, 1000.00, 20, 1), 
('Aila', 'Anstis', 'aanstis10', 'pass', 1, 1000.00, 8, 3),
('Vern', 'Pantling', 'vpantling11', 'pass', 1, 1000.00, 8, 3), 
('Ambrosi', 'Cheverell', 'acheverell12', 'pass', 1, 1000.00, 8, 3),
('Agnella', 'Jakoviljevic', 'ajakoviljevic13', 'pass', 1, 1000.00, 10, 2),
('Amy', 'Rudram', 'arudram14', 'pass', 1, 1000.00, 8, 3), 
('Gail', 'Vittet', 'gvittet15', 'pass', 1, 1000.00, 8, 3), 
('Aeriell', 'Yashnov', 'ayashnov16', 'pass', 4, 1000.00, 4, 4),
('Sheena', 'Medgewick', 'smedgewick17', 'pass', 1, 1000.00, 8, 3), 
('Dasha', 'Center', 'dcenter18', 'pass', 1, 1000.00, 20, 1),
('Uriah', 'Jaycock', 'ujaycock19', 'pass', 1, 1000.00, 8, 3), 
('Alva', 'Wimlett', 'awimlett1a', 'pass', 1, 1000.00, 8, 3), 
('Shanon', 'Yelding', 'syelding1b', 'pass', 2, 1000.00, 4, 4), 
('Nola', 'Avard', 'navard1c', 'pass', 3, 1000.00, 49, 5), 
('Fae', 'Truce', 'ftruce1d', 'pass', 1, 1000.00, 8, 3);


INSERT INTO department
(dept_name, dept_head_id)
VALUES
('IT', 34),
('Training', 12),
('Research and Development', 17),
('Human Resources', 4),
('Business Development', 49);


INSERT INTO event_type
(type_name, percent_coverage)
VALUES
('University Course', 80),
('Seminar', 60),
('Certification Prep', 75),
('Certification', 100),
('Technical Training', 90),
('Other', 30);


INSERT INTO grading_format
(format_name, example)
VALUES
('Pass/Fail', 'Pass'),
('A,B,C,D,F', 'A,B,C'),
('Percentage', '80% or higher'),
('Other', 'TBD');


INSERT INTO status
(status_name, approver)
VALUES
('Pending Approval', 'Supervisor'),		    	--1
('Denied', 'Supervisor'),						--2
('Approved', 'Supervisor'),						--3
('Pending Approval', 'Manager'),				--4	
('Denied', 'Manager'),							--5
('Approved', 'Manager'),						--6
('Pending Approval', 'Benefits Coordinator'),	--7	
('Denied', 'Benefits Coordinator'),				--8
('Approved', 'Benefits Coordinator');			--9


INSERT INTO reimbursement
(emp_id, event_date, event_time, location, description, cost, grading_format_id, event_type_id, status_id, submitted_at)
VALUES
(34, '6/22/2021', '22:25:42.000', 'Capitol College', 'matrix', 409.39, 2, 5, 9, '23:29:05'),			--1
(13, '2/16/2021', '6:06:27.000', 'Tokyo University', 'Adaptive', 307.74, 2, 4, 5, '9:54:46'),			--2
(19, '7/8/2021', '0:35:57.000', 'University of London', 'didactic', 357.56, 2, 3, 9, '19:00:04'),		--3
(45, '7/18/2021', '3:44:44.000', 'University of London', 'Enhanced', 423.44, 2, 3, 4, '20:59:42'),		--4
(27, '3/2/2021', '17:22:57.000', 'Tokyo University', 'optimal', 251.27, 3, 1, 1, '17:06:42'),			--5
(34, '12/13/2021', '16:02:16.000', 'Capitol College', 'empowering', 370.57, 1, 2, 7, '7:23:55'),		--6
(23, '2/6/2021', '12:42:45.000', 'Tokyo University', 'Re-engineered', 253.02, 3, 3, 9, '21:04:21'),		--7
(47, '10/22/2021', '15:06:25.000', 'University of Mosul', 'Universal', 411.58, 2, 3, 8, '10:39:16'),	--8
(3, '1/12/2021', '13:38:56.000', 'University of London', 'Synergistic', 299.16, 2, 4, 4, '11:35:46'),	--9
(31, '12/1/2021', '13:25:07.000', 'Capitol College', 'superstructure', 366.78, 1, 1, 9, '3:15:53'),		--10
(21, '4/12/2021', '15:36:05.000', 'Griffith University', 'dedicated', 488.40, 1, 2, 1, '10:46:36'),		--11
(13, '9/8/2021', '10:38:17.000', 'University of London', 'encryption', 276.31, 2, 3, 4, '15:31:27'),	--12
(13, '12/18/2021', '2:51:22.000', 'University of London', 'Compatible', 111.25, 2, 6, 2, '6:30:35'),	--13
(3, '7/1/2021', '10:28:40.000', 'University of Mosul', 'analyzer', 333.78, 1, 3, 9, '7:57:50'),			--14
(47, '7/10/2021', '3:29:00.000', 'University of London', 'product', 371.91, 1, 6, 9, '6:23:29'), 		--15
(23, '7/27/2021', '0:40:43.000', 'Capitol College', 'methodical', 420.22, 2, 1, 1, '21:47:03'),			--16
(45, '7/13/2021', '2:07:10.000', 'Tokyo University', 'initiative', 306.85, 1, 2, 9, '10:52:20'), 		--17
(21, '10/25/2021', '17:22:21.000', 'University of London', 'Synchronised', 256.07, 3, 6, 1, '0:12:41'),	--18
(19, '3/4/2021', '23:49:33.000', 'University of Mosul', 'Compatible', 222.58, 1, 2, 4, '20:12:36'),		--19
(3, '10/27/2021', '7:59:21.000', 'Tokyo University', 'reciprocal', 123.29, 2, 1, 5, '22:43:15');		--20


INSERT INTO comment
(req_id, approver_id, comment_text, sent_at)
VALUES
(2, 8, 'Pending Approval', '9:05 PM'),			-- role = 1		Supervisor level
(3, 8, 'Pending Approval', '3:21 PM'),			-- role = 1		
(4, 20, 'Pending Approval', '6:28 AM'),			-- role = 1
(5, 48, 'Pending Approval', '2:50 PM'),			-- role = 1
(7, 10, 'Pending Approval', '6:48 AM'),			-- role = 1
(8, 8, 'Pending Approval', '8:24 AM'),			-- role = 1
(10, 8, 'Pending Approval', '9:43 PM'),			-- role = 1
(11, 8, 'Pending Approval', '11:17 AM'),		-- role = 1
(12, 8, 'Pending Approval', '7:14 AM'),			-- role = 1
(13, 8, 'Pending Approval', '4:31 PM'),			-- role = 1
(15, 8, 'Pending Approval', '4:56 AM'),			-- role = 1
(16, 10, 'Pending Approval', '6:02 PM'),		-- role = 1
(17, 8, 'Pending Approval', '9:12 AM'),			-- role = 1
(18, 8, 'Pending Approval', '7:41 PM'),			-- role = 1
(19, 8, 'Pending Approval', '12:26 AM'),		-- role = 1
(2, 8, 'Approved', '7:01 AM'),					-- role = 1	
(3, 8, 'Approved', '7:26 PM'),					-- role = 1	
(4, 20, 'Approved', '10:20 PM'),				-- role = 1
(7, 10, 'Approved', '5:07 AM'),					-- role = 1
(8, 8, 'Approved', '2:12 PM'),					-- role = 1
(10, 8, 'Approved', '1:49 PM'),					-- role = 1
(12, 8, 'Approved', '3:57 AM'),					-- role = 1
(13, 8, 'Denied', '7:36 AM'),					-- role = 1
(15, 8, 'Approved', '9:02 AM'),					-- role = 1
(17, 8, 'Approved', '1:05 AM'),					-- role = 1
(19, 8, 'Approved', '4:45 AM'),					-- role = 1
(2, 17, 'Pending Approval', '9:57 PM'),			-- role = 1     Manager level
(3, 17, 'Pending Approval', '1:10 AM'),			-- role = 1
(4, 34, 'Pending Approval', '4:33 PM'),			-- role = 1
(7, 1, 'Pending Approval', '11:46 AM'),			-- role = 1
(8, 17, 'Pending Approval', '1:26 PM'),			-- role = 1
(9, 49, 'Pending Approval', '7:09 PM'),			-- role = 2
(10, 17, 'Pending Approval', '4:41 PM'),		-- role = 1
(12, 17, 'Pending Approval', '1:11 AM'),		-- role = 1
(14, 49, 'Pending Approval', '3:48 PM'),		-- role = 2
(15, 17, 'Pending Approval', '4:39 AM'),		-- role = 1
(17, 17, 'Pending Approval', '10:51 AM'),		-- role = 1
(19, 17, 'Pending Approval', '4:46 AM'),		-- role = 1
(20, 49, 'Pending Approval', '4:15 AM'),		-- role = 2
(2, 17, 'Denied', '7:48 AM'),					-- role = 1
(3, 17, 'Approved', '6:16 AM'),					-- role = 1
(7, 1, 'Approved', '11:22 PM'),					-- role = 1
(8, 17, 'Approved', '3:10 AM'),					-- role = 1
(10, 17, 'Approved', '3:46 AM'),				-- role = 1
(14, 49, 'Approved', '5:09 AM'),				-- role = 2
(15, 17, 'Approved', '7:36 AM'),				-- role = 1
(17, 17, 'Approved', '9:51 PM'),				-- role = 1
(20, 49, 'Denied', '9:14 AM'),					-- role = 2
(1, 43, 'Pending Approval', '7:02 AM'),			-- role = 3      BenCo level
(3, 43, 'Pending Approval', '2:42 AM'),			-- role = 1
(6, 43, 'Pending Approval', '3:17 PM'),			-- role = 3      
(7, 43, 'Pending Approval', '8:46 AM'),			-- role = 1
(8, 43, 'Pending Approval', '9:04 PM'),			-- role = 1     
(10, 43, 'Pending Approval', '2:34 AM'),		-- role = 1
(14, 43, 'Pending Approval', '6:04 AM'),		-- role = 2      
(15, 43, 'Pending Approval', '2:57 AM'),		-- role = 1
(17, 43, 'Pending Approval', '3:59 PM'),		-- role = 1     
(1, 43, 'Approved', '7:26 AM'),					-- role = 3
(3, 43, 'Approved', '2:39 AM'),					-- role = 1
(7, 43, 'Approved', '9:49 PM'),					-- role = 1
(8, 43, 'Denied', '4:31 PM'),					-- role = 1
(10, 43, 'Approved', '2:21 AM'),				-- role = 1
(14, 43, 'Approved', '3:16 AM'),				-- role = 2
(15, 43, 'Approved', '9:30 PM'),				-- role = 1
(17, 43, 'Approved', '3:45 AM'),				-- role = 1










































