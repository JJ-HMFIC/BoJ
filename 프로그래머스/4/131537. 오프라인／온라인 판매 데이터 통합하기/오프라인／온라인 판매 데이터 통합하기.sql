-- 코드를 입력하세요
SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, 
PRODUCT_ID, 
USER_ID, 
SALES_AMOUNT

from Online_sale 

where sales_date like '2022-03%'


union all 

SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
PRODUCT_ID,
Null as USER_ID, 
SALES_AMOUNT
from Offline_sale 

where sales_date like '2022-03%'

order by sales_date asc, product_id asc, user_id asc