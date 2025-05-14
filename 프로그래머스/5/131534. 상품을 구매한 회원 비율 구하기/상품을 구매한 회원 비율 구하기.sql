SELECT 
  YEAR(os.sales_date) AS year, 
  MONTH(os.sales_date) AS month, 
  COUNT(DISTINCT ui.user_id) AS purchased_users,
  ROUND(
    COUNT(DISTINCT ui.user_id) / 
    (SELECT COUNT(DISTINCT user_id) 
     FROM user_info 
     WHERE YEAR(joined) = 2021), 
    1
  ) AS purchased_ratio
FROM user_info ui
JOIN online_sale os ON ui.user_id = os.user_id
WHERE YEAR(ui.joined) = 2021
GROUP BY YEAR(os.sales_date), MONTH(os.sales_date)
ORDER BY year, month;