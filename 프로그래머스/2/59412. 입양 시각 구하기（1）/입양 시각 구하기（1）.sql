select hour(datetime) as hour, count(*)
from animal_outs
where 9 <= hour(datetime) and hour(datetime) <= 19
group by hour(datetime)
order by 1