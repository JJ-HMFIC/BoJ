with recursive hours as(
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
)

select h.hour , count(a.Animal_id) as 'count'
from hours h left join ANIMAL_OUTS a
on h.hour = hour(a.datetime)
group by h.hour
order by h.hour