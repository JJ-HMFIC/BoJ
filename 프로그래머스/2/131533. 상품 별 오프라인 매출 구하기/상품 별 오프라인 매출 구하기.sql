-- 코드를 입력하세요
SELECT p.PRODUCT_CODE , sum(os.SALES_AMOUNT) * p.price as SALES
from product p join OFFLINE_SALE os
on p.PRODUCT_ID = os.PRODUCT_ID

group by os.PRODUCT_ID
order by sum(os.SALES_AMOUNT) * p.price desc , p.PRODUCT_CODE asc