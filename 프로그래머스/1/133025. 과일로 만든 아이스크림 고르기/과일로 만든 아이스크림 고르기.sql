-- 코드를 입력하세요
SELECT fh.flavor
from FIRST_HALF fh join ICECREAM_INFO  ii
on fh.flavor = ii.flavor
where fh.TOTAL_ORDER>=3000 and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.total_order desc

