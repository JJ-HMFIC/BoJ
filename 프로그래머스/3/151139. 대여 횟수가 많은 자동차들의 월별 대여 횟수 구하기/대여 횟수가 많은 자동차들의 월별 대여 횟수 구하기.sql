-- 코드를 입력하세요
SELECT  month(START_DATE) as month , CAR_ID , count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c
where year(START_DATE) = 2022 and month(START_DATE) in (8,9,10)
and car_id in(
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE) = 2022 and month(START_DATE) in (8,9,10)
    group by car_id
    having count(*) >=5
    
)
group by month(START_DATE) , car_id
order by month asc, car_id desc

