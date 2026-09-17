-- 코드를 작성해주세요
select count(*) as fish_count, i.FISH_name
from FISH_INFO fi join FISH_NAME_INFO i
on fi.FISH_TYPE = i.FISH_TYPE

group by i.FISH_TYPE
order by fish_count desc
