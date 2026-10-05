-- 코드를 입력하세요
SELECT distinct(car.car_id)
from CAR_RENTAL_COMPANY_CAR car join CAR_RENTAL_COMPANY_RENTAL_HISTORY history
on car.car_id = history.car_id

where car.CAR_TYPE = '세단' and month(history.START_DATE) = 10


order by car.car_id desc