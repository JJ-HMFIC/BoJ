-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.animal_type, ins.name

from ANIMAL_INS ins join ANIMAL_OUTS outs
on ins.ANIMAL_ID = outs.ANIMAL_ID

where ins.SEX_UPON_INTAKE not like '%Neu%' and outs.SEX_UPON_OUTCOME != ins.SEX_UPON_INTAKE

order by ins.ANIMAL_ID asc