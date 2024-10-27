SELECT car_id,
    (CASE 
        WHEN (SELECT COUNT(*) 
              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
              WHERE h.car_id = c.car_id 
              AND '2022-10-16' BETWEEN DATE_FORMAT(h.start_date, '%Y-%m-%d') AND DATE_FORMAT(h.end_date, '%Y-%m-%d')) > 0 
        THEN '대여중' 
        ELSE '대여 가능' 
    END) AS availability
FROM (SELECT DISTINCT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) c
ORDER BY car_id DESC;

