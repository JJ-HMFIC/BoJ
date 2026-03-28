-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPER_INFOS 
where skill_1 = 'PYTHON'
OR SKILL_2 = 'PYTHON'
OR SKILL_3 = 'PYTHON'

ORDER BY ID