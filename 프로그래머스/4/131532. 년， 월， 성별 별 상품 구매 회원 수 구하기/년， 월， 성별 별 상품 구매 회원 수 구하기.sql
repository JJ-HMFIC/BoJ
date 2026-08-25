-- 코드를 입력하세요
SELECT year(SALES_DATE) as 'YEAR' , month(SALES_DATE) as 'Month', u.gender,
count(distinct u.user_id) as 'USERS'
from USER_INFO u join ONLINE_SALE o
on u.user_id = o.user_id
where u.gender is not null
group by year(SALES_DATE), month(SALES_DATE), u.gender
order by year asc, month asc, gender asc