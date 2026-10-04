-- 코드를 작성해주세요
select d.id, d.email, d.first_name, d.last_name
from DEVELOPERS d join SKILLCODES s
on (d.skill_code & s.code) > 0
where s.CATEGORY ='Front End'

group by d.id
order by d.id asc