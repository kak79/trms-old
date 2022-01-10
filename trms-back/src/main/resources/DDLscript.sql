

drop table if exists comment cascade;
drop table if exists reimbursement cascade;
drop table if exists status cascade;
drop table if exists grading_format cascade;
drop table if exists event_type cascade;
drop table if exists department cascade;
drop table if exists employee cascade;

drop table if exists department;
drop table if exists employee;
drop table if exists user_role;


create table if not exists user_role (
	role_id serial unique primary key,
	role_name varchar(30)
);


create table if not exists employee (
	emp_id serial unique primary key,
	first_name varchar(40),
	last_name varchar(40),
	username varchar(30),
	passwd varchar(25),
	role_id integer not null references user_role,
	funds real,
	supervisor_id integer,
	dept_id integer
);


create table if not exists department (
	dept_id serial unique primary key,
	dept_name varchar(30), 
	dept_head_id integer references employee
);


create table if not exists event_type (
	type_id serial unique primary key,
	type_name varchar(30), 
	percent_coverage integer 
);


create table if not exists grading_format (
	format_id serial unique primary key,
	format_name varchar(30), 
	example varchar(30)
);


create table if not exists status (
	status_id serial unique primary key,
	status_name varchar(30), 
	approver varchar(30) 
);


create table if not exists reimbursement (
	req_id serial unique primary key,
	emp_id integer references employee,
	event_date date, 
	event_time time, 
	location varchar(50), 
	description varchar(75), 
	cost real,
	grading_format_id integer references grading_format,
	event_type_id integer references event_type,
	status_id integer references status, 
	submitted_at time
);


create table if not exists comment (
	comment_id serial unique primary key,
	req_id integer references reimbursement,
	approver_id integer references employee, 
	comment_text varchar(100), 
	sent_at time 
);




alter table employee 
add constraint dept_id
foreign key (dept_id)
references department (dept_id);

alter table employee 
add constraint supervisor_id
foreign key (supervisor_id)
references employee (emp_id);








