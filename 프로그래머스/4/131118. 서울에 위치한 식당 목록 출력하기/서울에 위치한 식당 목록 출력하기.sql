-- 코드를 입력하세요
SELECT ri.rest_id, ri.rest_name, ri.FOOD_TYPE, ri.FAVORITES,ri.address, round(avg(rr.review_score),2) as 'SCORE'
from REST_INFO ri join REST_REVIEW rr
on ri.rest_id = rr.REST_ID

where ri.address like '서울%'
group by ri.rest_id
order by SCORE desc, ri.FAVORITES desc