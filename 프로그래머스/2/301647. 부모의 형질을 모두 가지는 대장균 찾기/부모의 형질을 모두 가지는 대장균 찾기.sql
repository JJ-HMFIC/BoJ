-- 코드를 작성해주세요
select b.id as 'id' , b.genotype as 'genotype' , a.genotype as'parent_genotype'
from ECOLI_DATA a join ECOLI_DATA b
on a.id = b.parent_id
where (a.genotype & b.genotype) = a.genotype
order by b.id asc