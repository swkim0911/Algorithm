# 1. 모든 id 들에 대해서 각각 몇 세대인지
with recursive ecoli_tree as (
    select 
        id,
        parent_id,
        1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select 
        e.id,
        e.parent_id,
        r.generation + 1 as generation
    from ecoli_data e
    join ecoli_tree r
        on e.parent_id = r.id
)

select count(*) as count, t.generation
from ecoli_tree t
left join ecoli_data d on t.id = d.parent_id
where d.parent_id is null
group by t.generation
order by t.generation