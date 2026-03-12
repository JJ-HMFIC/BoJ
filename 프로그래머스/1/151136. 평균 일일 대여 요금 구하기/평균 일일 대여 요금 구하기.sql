-- 코드를 입력하세요
SELECT round(avg(c.daily_fee),0) as 'AVERAGE_FEE'
from CAR_RENTAL_COMPANY_CAR c
where c.car_type ='SUV'