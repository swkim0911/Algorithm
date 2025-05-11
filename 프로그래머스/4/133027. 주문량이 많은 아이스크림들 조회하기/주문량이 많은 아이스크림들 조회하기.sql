-- 코드를 입력하세요
# SELECT * from first_half fh left join july j on fh.flavor = j.flavor
# first_half에는 flavor가 pk니까 중복되는 건 없음. 하지만 july는 있음.
select fh.flavor
from first_half fh left join (select flavor, sum(total_order) as total_order from july group by flavor) j on fh.flavor = j.flavor order by (fh.total_order + j.total_order) desc limit 3