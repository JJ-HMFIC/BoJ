-- 코드를 입력하세요

select outs.ANIMAL_ID, outs.name
from animal_outs outs
where ANIMAL_ID not in(
    SELECT ins.ANIMAL_ID
    from ANIMAL_INS ins join ANIMAL_outs outs
    on ins.ANIMAL_Id = outs.ANIMAL_id
    group by ins.animal_id
)


order by outs.ANIMAL_ID 
