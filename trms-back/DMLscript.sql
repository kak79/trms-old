


INSERT INTO user_role
(role_name)
VALUES
('User'),
('Supervisor'),
('Department Manager'),
('THE ADMIN'),
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
('Phelia', 'O''Canavan', 'pocanavann', 'pass', 1, 1000.00, 8,3 ),
('Noel', 'Hawsby', 'nhawsbyo', 'pass', 1, 1000.00, 10, 2),
('Fernandina', 'McLaren', 'fmclarenp', 'pass', 1, 1000.00, 8, 3),
('Cornelius', 'Bowcock', 'cbowcockq', 'pass', 1, 1000.00, 48, 4),
('Vasilis', 'McFfaden', 'vmcffadenr', 'pass', 1, 1000.00, 10, 2),
('Rhona', 'Phil', 'rphils', 'pass', 1, 1000.00, 8, 3), 
('Gilles', 'Hallgarth', 'ghallgartht', 'pass', 1, 1000.00, 8, 3),
('Layla', 'Paur', 'lpauru', 'pass', 1, 1000.00, 8, 3),
('Roberto', 'Hitchens', 'rhitchensv', 'pass', 1, 1000.00, 10, 2),
('Mauricio', 'Kohneke', 'mkohnekew', 'pass', 1, 1000.00, 8, 3), 
('Otto', 'Ommundsen', 'oommundsenx', 'pass', 4, 1000.00, 34, 1),
('Kial', 'Late', 'klatey', 'pass', 1, 1000.00, 8,3 ), 
('Tripp', 'Umney', 'tumneyz', 'pass', 1, 1000.00, 20, 1), 
('Aila', 'Anstis', 'aanstis10', 'pass', 1, 1000.00, 8, 3),
('Vern', 'Pantling', 'vpantling11', 'pass', 1, 1000.00, 8, 3), 
('Ambrosi', 'Cheverell', 'acheverell12', 'pass', 1, 1000.00, 8, 3),
('Agnella', 'Jakoviljevic', 'ajakoviljevic13', 'pass', 1, 1000.00, 10, 2),
('Amy', 'Rudram', 'arudram14', 'pass', 1, 1000.00, 8, 3), 
('Gail', 'Vittet', 'gvittet15', 'pass', 1, 1000.00, 8, 3), 
('Aeriell', 'Yashnov', 'ayashnov16', 'pass', 5, 1000.00, 4, 4),
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
('Training', 1),
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
('Auto-Approved', 'System'),
('Denied', 'Supervisor'),
('Approved', 'Supervisor'),
('Denied', 'Manager'),
('Approved', 'Manager'),
('Denied', 'Benefits Coordinator'),
('Approved', 'Benefits Coordinator');


INSERT INTO reimbursement
(emp_id, event_date, event_time, location, description, cost, grading_format_id, event_type_id, status_id, submitted_at)
VALUES
(30, '6/22/2021', '22:25:42.000', 'University of Philippines', 'matrix', 409.39, 2, 5, 7, '23:29:05'),
(14, '2/16/2021', '6:06:27.000', 'Peace College', 'Adaptive', 307.74, 2, 4, 1, '9:54:46'),
(20, '7/8/2021', '0:35:57.000', 'Petersburg Institute of Technology', 'didactic', 357.56, 2, 3, 1, '19:00:04'),
(46, '7/18/2021', '3:44:44.000', 'Universidad Fidélitas', 'Enhanced', 423.44, 2, 3, 3, '20:59:42'),
(28, '3/2/2021', '17:22:57.000', 'Tokyo University', 'optimal', 251.27, 3, 1, 6, '17:06:42'),
(12, '12/13/2021', '16:02:16.000', 'Kalmar University College', 'empowering', 370.57, 1, 2, 1, '7:23:55'),
(24, '2/6/2021', '12:42:45.000', 'Universidad Libre de Colombia', 'Re-engineered', 253.02, 3, 3, 1, '21:04:21'),
(48, '10/22/2021', '15:06:25.000', 'University of Mosul', 'Universal', 411.58, 2, 3, 7, '10:39:16'),
(4, '1/12/2021', '13:38:56.000', 'Islamic Azad University, Majlesi', 'Synergistic', 299.16, 2, 4, 7, '11:35:46'),
(32, '12/1/2021', '13:25:07.000', 'Capitol College', 'superstructure', 366.78, 1, 1, 5, '3:15:53'),
(42, '4/12/2021', '15:36:05.000', 'Griffith University', 'dedicated', 488.40, 1, 2, 2, '10:46:36'),
(14, '9/8/2021', '10:38:17.000', 'Okinawa Prefectural University', 'encryption', 276.31, 2, 3, 4, '15:31:27'),
(14, '12/18/2021', '2:51:22.000', 'Universidad de la Cuenca del Plata', 'Compatible', 111.25, 2, 6, 7, '6:30:35'),
(6, '7/1/2021', '10:28:40.000', 'Universidad Nacional de Catamarca', 'analyzer', 333.78, 1, 3, 5, '7:57:50'),
(38, '7/10/2021', '3:29:00.000', 'University of London', 'product', 371.91, 1, 6, 1, '6:23:29'), 
(24, '7/27/2021', '0:40:43.000', 'Changsha University of Electric Power', 'methodical', 420.22, 2, 1, 6, '21:47:03'),
(50, '7/13/2021', '2:07:10.000', 'L''Université de l''Entreprise', 'initiative', 306.85, 1, 2, 5, '10:52:20'), 
(22, '10/25/2021', '17:22:21.000', 'Ecole National d''Agriculture de Meknes', 'Synchronised', 256.07, 3, 6, 4, '0:12:41'),
(42, '3/4/2021', '23:49:33.000', 'Sri Institute of Medical Sciences', 'Compatible', 222.58, 1, 2, 3, '20:12:36'),
(10, '10/27/2021', '7:59:21.000', 'Southwest Forestry University', 'reciprocal', 123.29, 2, 1, 1, '22:43:15');


INSERT INTO comment
(req_id, approver_id, comment_text, sent_at)
VALUES
(1, 43, 'Polarised methodical access', '8:56:03'),
(2, 34, 'Decentralized 3rd generation encryption', '16:26:13'),
(3, 1, 'Open-architected asymmetric firmware', '3:52:08'),
(4, 34, 'Upgradable content-based synergy', '8:01:03'),
(6, 49, 'Progressive foreground frame', '7:35:55'),
(7, 43, 'Persevering didactic definition', '16:55:07'),
(8, 43, 'Proactive responsive success', '2:21:47'),
(9, 17, 'Devolved content-based task-force', '22:04:18'),
(10, 43, 'Self-enabling client-server orchestration', '9:03:46'),
(13, 49, 'Pre-emptive stable encoding', '12:47:36'), 
(14, 11, 'Streamlined asymmetric initiative', '17:45:58'),
(15, 43, 'Open-architected web-enabled leverage', '2:19:17'),
(17, 43, 'Innovative transitional alliance', '12:43:29'),
(19, 1, 'Organized didactic protocol', '3:54:43'),
(20, 17, 'Switchable 5th generation solution', '20:54:12');















































