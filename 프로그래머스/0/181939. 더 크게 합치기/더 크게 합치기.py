def combine(a,b):
    return str(a) + str(b)

def solution(a, b):
    
    return int(combine(a,b)) if int(combine(a,b)) >= int(combine(b,a)) else int(combine(b,a))