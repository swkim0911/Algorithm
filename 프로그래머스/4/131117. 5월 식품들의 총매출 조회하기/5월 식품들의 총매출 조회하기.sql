-- 코드를 입력하세요
select fd.product_id, fd.product_name, sum(fd.price * fo.amount) as total_sales
from food_product fd join food_order fo on fd.product_id = fo.product_id 
where fo.produce_date >= '2022-05-01' and fo.produce_date <= '2022-05-31'
group by fd.product_id
order by 3 desc, 1 asc