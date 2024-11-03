

select hg.score, he.emp_no, he.emp_name, he.position, he.email
from hr_employees he join (select emp_no, sum(score) as score from hr_grade group by emp_no order by 2 desc limit 1) hg on he.emp_no = hg.emp_no