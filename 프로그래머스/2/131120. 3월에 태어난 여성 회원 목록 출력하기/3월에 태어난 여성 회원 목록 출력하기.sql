-- 코드를 입력하세요
SELECT MEMBER_id, MEMBER_NAME, gender, date_format(date_of_birth, '%Y-%m-%d') as 'DATE_OF_BIRTH'
from MEMBER_PROFILE
where gender = 'W'
and TLNO is not null
and date_format(DATE_OF_BIRTH, '%m') = 03
order by MEMBER_id asc
