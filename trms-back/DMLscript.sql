

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
(34, '6/22/2021', '22:25:42', 'Capitol College', 'matrix', 409.39, 2, 5, 9, '23:29:05'),				--1
(13, '2/16/2021', '6:06:27', 'Tokyo University', 'Adaptive', 307.74, 2, 4, 1, '09:54:46'),				--2
(19, '7/8/2021', '0:35:57', 'University of London', 'didactic', 357.56, 2, 3, 1, '19:00:04'),			--3
(45, '7/18/2021', '3:44:44', 'University of London', 'Enhanced', 423.44, 2, 3, 1, '20:59:42'),			--4
(27, '3/2/2021', '17:22:57', 'Tokyo University', 'optimal', 251.27, 3, 1, 1, '17:06:42'),				--5
(34, '12/13/2021', '16:02:16', 'Capitol College', 'empowering', 370.57, 1, 2, 7, '07:23:55'),			--6
(23, '2/6/2021', '12:42:45', 'Tokyo University', 'Re-engineered', 253.02, 3, 3, 1, '21:04:21'),			--7
(47, '10/22/2021', '15:06:25', 'University of Mosul', 'Universal', 411.58, 2, 3, 1, '10:39:16'),		--8
(8, '1/12/2021', '13:38:56', 'University of London', 'Synergistic', 299.16, 2, 4, 4, '11:35:46'),		--9
(31, '12/1/2021', '13:25:07', 'Capitol College', 'superstructure', 366.78, 1, 1, 1, '03:15:53'),		--10
(21, '4/12/2021', '15:36:05', 'Griffith University', 'dedicated', 488.40, 1, 2, 1, '10:46:36'),			--11
(13, '9/8/2021', '10:38:17', 'University of London', 'encryption', 276.31, 2, 3, 1, '15:31:27'),		--12
(13, '12/18/2021', '2:51:22', 'University of London', 'Compatible', 111.25, 2, 6, 1, '06:30:35'),		--13
(8, '7/1/2021', '10:28:40', 'University of Mosul', 'analyzer', 333.78, 1, 3, 9, '07:57:50'),			--14
(47, '7/10/2021', '3:29:01', 'University of London', 'product', 371.91, 1, 6, 1, '06:23:29'), 			--15
(23, '7/27/2021', '0:40:43', 'Capitol College', 'methodical', 420.22, 2, 1, 1, '21:47:03'),				--16
(45, '7/13/2021', '2:07:10', 'Tokyo University', 'initiative', 306.85, 1, 2, 1, '10:52:20'), 			--17
(21, '10/25/2021', '17:22:21', 'University of London', 'Synchronised', 256.07, 3, 6, 1, '00:12:41'),	--18
(19, '3/4/2021', '23:49:33', 'University of Mosul', 'Compatible', 222.58, 1, 2, 1, '20:12:36'),			--19
(8, '10/27/2021', '7:59:21', 'Tokyo University', 'reciprocal', 123.29, 2, 1, 5, '22:43:15');			--20


INSERT INTO comment
(req_id, approver_id, comment_text, sent_at)
VALUES
(2, 8, 'Pending Approval', '17:05:25'),			-- role = 1		Supervisor level
(3, 8, 'Pending Approval', '15:21:15'),			-- role = 1		
(4, 20, 'Pending Approval', '06:28:12'),		-- role = 1
(5, 48, 'Pending Approval', '14:50:42'),		-- role = 1
(7, 10, 'Pending Approval', '06:48:51'),		-- role = 1
(8, 8, 'Pending Approval', '08:24:02'),			-- role = 1
(10, 8, 'Pending Approval', '21:43:11'),		-- role = 1
(11, 8, 'Pending Approval', '11:17:17'),		-- role = 1
(12, 8, 'Pending Approval', '07:14:14'),		-- role = 1
(13, 8, 'Pending Approval', '16:31:31'),		-- role = 1
(15, 8, 'Pending Approval', '04:56:56'),		-- role = 1
(16, 10, 'Pending Approval', '18:02:02'),		-- role = 1
(17, 8, 'Pending Approval', '09:12:12'),		-- role = 1
(18, 8, 'Pending Approval', '19:41:41'),		-- role = 1
(19, 8, 'Pending Approval', '00:26:26'),		-- role = 1
(9, 17, 'Pending Approval', '19:09:09'),		-- role = 2    Manager level
(14, 17, 'Pending Approval', '15:48:48'),		-- role = 2
(20, 17, 'Pending Approval', '04:15:15'),		-- role = 2
(14, 17, 'Approved', '05:09:09'),				-- role = 2
(20, 17, 'Denied', '09:14:14'),					-- role = 2
(1, 43, 'Pending Approval', '07:02:02'),		-- role = 3      BenCo level
(6, 43, 'Pending Approval', '15:17:17'),		-- role = 3      
(14, 43, 'Pending Approval', '06:04:04'),		-- role = 2      
(1, 43, 'Approved', '07:26:26'),				-- role = 3
(14, 43, 'Approved', '03:16:16');				-- role = 2










































