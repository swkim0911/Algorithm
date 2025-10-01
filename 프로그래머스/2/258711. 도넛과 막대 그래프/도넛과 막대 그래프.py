from collections import defaultdict
from itertools import combinations, permutations

def solution(edges):
    answer = [0] * 4
    degree_dic = defaultdict(lambda: [0,0]) # dict[x][0] = 나가는 degree, dict[x][1] = 들어오는 degree
    for edge in edges:
        a,b = edge
        degree_dic[a][0] += 1
        degree_dic[b][1] += 1
    
    inserted_node = 0
    for node, degrees in degree_dic.items():
        out_degree, in_degree = degrees
        if out_degree > 1 and in_degree == 0:
            inserted_node = node
        elif out_degree == 0:
            answer[2] += 1
        elif out_degree == 2 and in_degree >= 2:
            answer[3] += 1
    answer[0] = inserted_node
    answer[1] = degree_dic[inserted_node][0] - (answer[2] + answer[3])
    
    
        
    return answer