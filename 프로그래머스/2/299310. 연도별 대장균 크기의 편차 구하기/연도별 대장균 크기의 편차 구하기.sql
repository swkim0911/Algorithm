select b.b_year as year, b.max_colony - a.size_of_colony as year_dev, a.id 
from ecoli_data a
join (select max(SIZE_OF_COLONY) as max_colony, year(DIFFERENTIATION_DATE) as b_year 
        from ecoli_data
        group by year(DIFFERENTIATION_DATE)) b on b_year = year(a.DIFFERENTIATION_DATE)
order by 1 asc, 2 asc

