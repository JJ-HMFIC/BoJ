-- 코드를 입력하세요
SELECT floor(price/10000)*10000 as price_group,count(product_id) as products
from PRODUCT
group by floor(price/10000) *10000
order by price_group asc