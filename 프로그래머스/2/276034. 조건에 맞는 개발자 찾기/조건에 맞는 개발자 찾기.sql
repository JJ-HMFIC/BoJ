-- 코드를 작성해주세요
select id, email, first_name, last_name
from developers

where skill_code & (select code from skillCodes where name = 'C#')
or skill_code & (select code from skillCodes where name = 'Python')

order by id
