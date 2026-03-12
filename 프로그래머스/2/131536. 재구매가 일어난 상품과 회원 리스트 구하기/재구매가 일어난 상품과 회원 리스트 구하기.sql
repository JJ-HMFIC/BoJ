-- 코드를 입력하세요
SELECT os.user_id, os.product_id
from ONLINE_SALE os
group by os.user_id, os.product_id 
having count(*) >1
order by os.user_id asc, os.product_id desc

