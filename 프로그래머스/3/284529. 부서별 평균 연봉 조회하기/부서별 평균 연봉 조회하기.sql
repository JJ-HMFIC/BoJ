-- 코드를 작성해주세요
select de.dept_id, de.DEPT_NAME_EN , round(avg(e.sal)) as avg_sal
from HR_DEPARTMENT de join HR_EMPLOYEES e
on de.dept_id = e.dept_id

group by de.dept_id , de.DEPT_NAME_EN 
order by avg_sal desc