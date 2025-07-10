-- 코드를 작성해주세요

select a.id, c.fish_name, b.length
from fish_info a join (select fish_type, max(length) as length
                        from fish_info
                        group by fish_type) b on a.fish_type = b.fish_type and a.length = b.length join fish_name_info c on a.fish_type = c.fish_type

order by 1 asc
                        
                        