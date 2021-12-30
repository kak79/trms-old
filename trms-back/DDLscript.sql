


drop table if exists comment cascade;
drop table if exists reimbursement cascade;
drop table if exists status cascade;
drop table if exists grading_format cascade;
drop table if exists event_type cascade;
drop table if exists department cascade;
drop table if exists employee cascade;
drop table if exists user_role cascade;


create table if not exists user_role (
	role_id serial unique not null primary key,
	role_name varchar(30) not null
);


create table if not exists employee (
	emp_id serial unique not null primary key,
	first_name varchar(40) not null,
	last_name varchar(40) not null,
	username varchar(30) not null,
	passwd varchar(25) not null,
	role_id integer not null references user_role,
	funds real not null,
	supervisor_id integer not null,
	dept_id integer not null
);


create table if not exists department (
	dept_id serial unique not null primary key,
	dept_name varchar(30) not null, 
	dept_head_id integer not null references employee
);


create table if not exists event_type (
	type_id serial unique not null primary key,
	type_name varchar(30) not null, 
	percent_coverage integer not null
);


create table if not exists grading_format (
	format_id serial unique not null primary key,
	format_name varchar(30) not null, 
	example varchar(30) not null
);


create table if not exists status (
	status_id serial unique not null primary key,
	status_name varchar(30) not null, 
	approver varchar(30) not null
);


create table if not exists reimbursement (
	req_id serial unique not null primary key,
	emp_id integer not null references employee,
	event_date date not null, 
	event_time time not null, 
	location varchar(50) not null, 
	description varchar(75) not null, 
	cost real not null,
	grading_format_id integer not null references grading_format,
	event_type_id integer not null references event_type,
	status_id integer not null references status, 
	submitted_at time not null
);


create table if not exists comment (
	comment_id serial unique not null primary key,
	req_id integer not null references reimbursement,
	approver_id integer not null references employee, 
	comment_text varchar(100) not null, 
	sent_at time not null
);




alter table employee 
add constraint dept_id
foreign key (dept_id)
references department (dept_id);

alter table employee 
add constraint supervisor_id
foreign key (supervisor_id)
references employee (emp_id);








































