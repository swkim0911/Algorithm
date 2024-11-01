with recursive time
as (
    select 0 as hour
    union all
    select hour + 1
    from time
    where hour < 23
    
)

select t.hour, count(animal_id)
from time t left join (select *, hour(datetime) as hour from animal_outs) a on t.hour = a.hour
group by t.hour
order by t.hour
