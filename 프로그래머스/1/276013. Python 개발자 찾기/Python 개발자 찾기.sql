select id, email, first_name, last_name
from developer_infos
where 'python' in (skill_1, skill_2, skill_3)
order by 1