

select ld.id, COALESCE(rd.child_count, 0) as child_count
from ecoli_data ld left join (
select parent_id, count(*) as child_count from ecoli_data
where parent_id is not null
group by parent_id) rd on ld.id = rd.parent_id
order by 1