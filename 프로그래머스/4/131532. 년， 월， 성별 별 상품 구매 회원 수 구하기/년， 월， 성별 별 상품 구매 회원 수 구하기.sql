-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, ui.gender as gender, count(DISTINCT ui.user_id) as users
from online_sale os join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by year(os.sales_date), month(os.sales_date), ui.gender
order by 1,2,3
