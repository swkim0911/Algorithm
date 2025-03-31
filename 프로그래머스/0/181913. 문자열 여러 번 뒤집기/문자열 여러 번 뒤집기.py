def solution(my_string, queries):
    str_list = list(my_string)
    for q in queries:
        s = q[0]
        e = q[1]
        sub_list = str_list[s:e+1]
        str_list = str_list[0:s] + list(reversed(sub_list)) + str_list[e+1:]
        
    return ''.join(str_list)