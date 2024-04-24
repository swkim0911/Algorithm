# select *
# from rest_info
# where rest_id

# select food_type, rest_id, rest_name, max(views)
# from rest_info
# group by food_type


select a.food_type, a.rest_id, a.rest_name, a.favorites
from rest_info a
join (select food_type, max(favorites) as favorites from rest_info group by food_type) b
on a.food_type = b.food_type and a.favorites = b.favorites
order by 1 desc
