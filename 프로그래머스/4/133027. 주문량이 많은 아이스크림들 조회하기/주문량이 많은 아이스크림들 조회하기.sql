-- 코드를 입력하세요
SELECT fh.flavor 
from first_half fh, july j
where fh.flavor = j.flavor
group by fh.flavor 
order by fh.total_order +sum(j.total_order) desc
limit 3