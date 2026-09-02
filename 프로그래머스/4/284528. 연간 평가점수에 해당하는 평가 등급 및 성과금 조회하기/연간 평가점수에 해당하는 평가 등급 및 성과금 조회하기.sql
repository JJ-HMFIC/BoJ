with result1 as(
    select 
    case when avg(g.score) >= 96 then 'S'
    when avg(g.score) >= 90 then 'A'
    when avg(g.score) >= 80 then 'B'
    else 'C' end as Grade , g.emp_no
    
    from hr_grade g
    
    group by g.emp_no
) 


select e.emp_no, e.emp_name, r.grade as grade,
case when r.Grade = 'S' then e.sal * 0.2
    when r.Grade ='A' then e.sal * 0.15
    when r.Grade = 'B' then e.sal * 0.1
    else 0 end as Bonus

from HR_EMPLOYEES e join result1 r
on e.emp_no = r.emp_no

