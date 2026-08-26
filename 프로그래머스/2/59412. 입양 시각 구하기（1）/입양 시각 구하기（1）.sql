-- 코드를 입력하세요
SELECT hour(datetime) as 'HOUR' , count(*) as 'COUNT'
from ANIMAL_OUTS 
where hour(datetime) >=9 and hour(datetime)<=19
group by hour(datetime)
order by hour(datetime) asc