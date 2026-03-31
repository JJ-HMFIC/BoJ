-- 코드를 작성해주세요
select a.id, ifnull(count(b.id),0) as 'child_count'
from ECOLI_DATA a left join ECOLI_DATA b
on a.id = b.parent_id
group by a.id