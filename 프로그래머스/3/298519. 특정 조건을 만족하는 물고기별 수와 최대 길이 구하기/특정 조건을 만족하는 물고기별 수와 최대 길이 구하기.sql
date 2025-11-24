-- 코드를 작성해주세요

select count(*) as fish_count, max(t.length) as max_length, t.fish_type
from (select id, fish_type, ifnull(length, 10) as length from fish_info) t
group by t.fish_type
having avg(t.length) >= 33
order by fish_type