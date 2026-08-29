-- 코드를 작성해주세요
with front as(
    select sum(CODE) as 'code'
    from skillcodes
    where category = 'Front End'
), Graded as(
    select
        Case 
            when (d.skill_code & f.code) > 0
            and (d.skill_code &(
                select s.code
                from skillcodes s
                where s.name = 'Python')) > 0 then 'A'
    
            when (d.skill_code & (
                select s.code
                from skillcodes s
                where s.name = 'C#')) > 0 then 'B'
    
            when (d.skill_code & f.code )>0 then 'C' 
    end as grade, d.id, d.email
    
    from developers d cross join front f
)
select grade, id, email
from graded
where grade is not null
order by grade , id