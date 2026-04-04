-- 코드를 작성해주세요
with recursive ECOLI_GEN as(
    select id ,parent_id, 1 as generation
    from ECOLI_data
    where parent_id is null
    
    union all
    
    select e.id ,e.parent_id, g.generation + 1
    from ECOLI_DATA e
    join ECOLI_GEN g on e.parent_id = g.id
    
)
SELECT count(*) as 'count', generation
FROM ecoli_gen g
left join ecoli_data d on g.id = d.parent_id
where d.id is null

group by generation
order by generation