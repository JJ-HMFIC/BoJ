-- 코드를 입력하세요
SELECT c.car_id , c.car_type , round(c.daily_fee *(1- p.discount_rate/100) * 30) As 'FEE'
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.CAR_TYPE = p.CAR_TYPE
where c.car_id not in(
    select h.car_id
    from  CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.START_DATE <='2022-11-30'
    and h.end_date >= '2022-11-01'
)
and c.CAR_TYPE in('세단','SUV')
and p.DURATION_TYPE = '30일 이상'
having FEE >=500000 and FEE < 2000000
order by FEE desc, c.car_type asc, c.car_id desc