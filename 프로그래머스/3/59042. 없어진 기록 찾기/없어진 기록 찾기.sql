-- 코드를 입력하세요
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 id와 이름


SELECT animal_id, name
from animal_outs 
where animal_id not in (select animal_id from animal_ins)