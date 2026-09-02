-- 코드를 작성해주세요
select sum(g.score) as 'score' , hr.emp_no, hr.emp_name,hr.position ,hr.email
from HR_EMPLOYEES hr join  HR_GRADE g
on hr.emp_no = g.emp_no
where g.year = 2022

group by hr.emp_no
order by sum(g.score) desc limit 1