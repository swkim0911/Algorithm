import math
def solution(num_list):
    s = sum(num_list)**2
    p = math.prod(num_list)
    
    return int(p < s)