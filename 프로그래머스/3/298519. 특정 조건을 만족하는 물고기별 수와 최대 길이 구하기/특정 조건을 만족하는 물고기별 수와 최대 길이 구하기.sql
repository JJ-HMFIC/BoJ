-- 코드를 작성해주세요
select  count(id) as fish_count, max(length) as MAX_LENGTH, fish_type
from FISH_INFO 

group by fish_type
having avg(ifnull(length,10)) >=33

order by fish_type 
