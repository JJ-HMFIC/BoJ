-- 코드를 입력하세요
SELECT c.car_type, count(*) as 'CARS'
from CAR_RENTAL_COMPANY_CAR C

where options like '%시트%' 
group by c.car_type
order by c.car_type asc
