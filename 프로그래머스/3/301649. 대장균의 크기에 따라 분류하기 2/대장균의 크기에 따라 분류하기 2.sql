-- 코드를 작성해주세요
select id ,
    case when nt = 1 then 'CRITICAL'
    WHEN NT =2 THEN 'HIGH'
    WHEN NT = 3 THEN 'MEDIUM'
    ELSE 'LOW'
    end as 'colony_name'
from (
    select id, ntile(4) over (order by SIZE_OF_COLONY DESC) as nt
    from ECOLI_DATA 
) as sub 
ORDER BY ID
