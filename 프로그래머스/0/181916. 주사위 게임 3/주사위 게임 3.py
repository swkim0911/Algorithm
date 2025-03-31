def solution(a, b, c, d):
    answer = 0
    arr = [a,b,c,d]
    dict = {}
    for v in arr:
        if v in dict:
            dict[v] += 1
        else:
            dict[v] = 1
            
    key_list = list(dict.keys())
    
    if len(key_list) == 1:
        answer = 1111 * key_list[0]
    elif len(key_list) == 2:
        p = key_list[0]
        q = key_list[1]
        if dict[p] == 2 and dict[q] == 2:
            answer = (p + q) * abs(p-q)
        elif dict[p] == 3:
            answer = (10 * p + q)**2
        else:
            answer = (10 * q + p)**2
    elif len(key_list) == 4:
        answer = min(key_list)
    else:
        sorted_dict = list(sorted(dict.items(), key = lambda x: x[1]))
        q = sorted_dict[0][0]
        r = sorted_dict[1][0]
        answer = q * r
        
            
            
    
        
    return answer