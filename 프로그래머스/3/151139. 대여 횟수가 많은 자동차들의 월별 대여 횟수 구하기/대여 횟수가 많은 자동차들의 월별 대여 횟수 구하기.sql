-- 코드를 입력하세요
select month(start_date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date) between 8 and 10
group by car_id
having count(*) >= 5)
and month(start_date) between 8 and 10
group by car_id, month(start_date)
having count(*) > 0
order by 1,2 desc