-- 코드를 입력하세요
SELECT ii.INGREDIENT_TYPE , sum(fh.TOTAL_ORDER) as 'total_order'
from first_half fh, ICECREAM_INFO ii
where fh.flavor = ii.flavor

group by ii.INGREDIENT_TYPE
order by total_order asc

