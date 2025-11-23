-- 코드를 입력하세요
select fp2.category, fp2.max_price, fp1.product_name
from food_product fp1
join (SELECT category, max(price) as max_price
        from food_product
        where category in ('과자', '국', '김치', '식용유')
        group by category)
    fp2 on fp1.category = fp2.category and fp1.price = fp2.max_price
order by 2 desc