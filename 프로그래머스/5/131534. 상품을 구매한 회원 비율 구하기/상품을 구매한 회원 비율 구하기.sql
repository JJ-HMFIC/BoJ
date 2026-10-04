with cnt as(
    select count(*) as users
    from USER_INFO 
    where year(JOINED) = 2021 
)


SELECT year(SALES_DATE) as year, month(SALES_DATE) as month, count(distinct(ui.user_id)) as PURCHASED_USERS,
round(count(distinct(ui.user_id)) / cnt.users,1) as PUCHASED_RATIO
from USER_INFO ui join ONLINE_SALE os
on ui.USER_ID = os.USER_ID, cnt

where year(ui.joined ) = 2021

group by year(SALES_DATE) , month(SALES_DATE)

order by year(SALES_DATE) asc, month(SALES_DATE) asc