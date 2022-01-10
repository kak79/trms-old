

select * from comment;

select * from comment where req_id=7;

select req_id, emp_id, event_date, event_time, location, 
description, cost, grading_format_id, format_name,
example as format_example, event_type_id, type_name,
percent_coverage, r.status_id, status_name, approver, 
submitted_at
from reimbursement r
join grading_format gf on r. grading_format_id=gf.format_id
join event_type et on r.event_type_id=et.type_id
join status s on r.status_id=s.status_id
where req_id=4

select * from reimbursement where req_id = 4;

select * from reimbursement where emp_id = 14;



SELECT 
req_id, emp_id, event_date, event_time, location,
description, cost, grading_format_id, format_name, 
example AS format_example, 
event_type_id, type_name, percent_coverage,
r.status_id, status_name, approver, submitted_at  
FROM reimbursement r
JOIN grading_format gf ON r.grading_format_id=gf.format_id 
JOIN event_type et ON r.event_type_id=et.type_id 
JOIN status s ON r.status_id=s.status_id
WHERE r.status_id=1;

