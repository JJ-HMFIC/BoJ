-- 코드를 작성해주세요
select count(*) as 'count'
from ECOLI_DATA
where genotype &(2)=0 and (GENOTYPE & (1) or genotype & (4))