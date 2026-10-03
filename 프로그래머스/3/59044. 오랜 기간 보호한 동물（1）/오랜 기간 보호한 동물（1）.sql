-- 코드를 입력하세요
SELECT ins.NAME , ins.DATETIME
from ANIMAL_INS ins

where ins.animal_id not in(
    select animal_id
    from ANIMAL_outs
    )
order by ins.DATETIME asc
limit 3
