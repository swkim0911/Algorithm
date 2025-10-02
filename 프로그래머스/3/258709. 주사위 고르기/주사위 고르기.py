from itertools import combinations
import math

def solution(dice):
    n = len(dice)
    idx_set = set(range(n))
    
    # 1. 주사위를 선택할 조합
    answer_arr = []
    max_wins = -1
    
    for combination in combinations(range(n), n // 2):
        a = set(combination)
        b = idx_set - a
        
        a = list(a)
        b = list(b)
        a_arr = [] # a가 가능한 모든 조합
        b_arr = [] # b가 가능한 모든 조합
    
        # 2. a 주사위 값의 모든 경우 (오름차순 정렬)
        for v in range(6**(n//2)):
            val = v
            total = 0
            for i in range(n//2):
                rest = val % 6
                total += dice[a[i]][rest]
                val //= 6
            a_arr.append(total)
        # 3. b 주사위 값의 모든 경우 (오름차순 정렬)
        
        for v in range(6**(n//2)):
            val = v
            total = 0
            for i in range(n//2):
                rest = val % 6
                total += dice[b[i]][rest]
                val //= 6
            b_arr.append(total)
        
        a_arr.sort()
        b_arr.sort()
        
        total_wins = 0
        for v in a_arr:
            wins = binary_search(v, b_arr)
            total_wins += wins
        
        if max_wins < total_wins:
            max_wins = total_wins
            answer_arr = a
        
    return [v + 1 for v in answer_arr]
            
# b_arr에서 val보다 같거나 커지는 구간 찾기 (val이 이기는 개수)
def binary_search(val, b_arr):
    left = 0
    right = len(b_arr) - 1
    while left < right:
        mid = (left + right) // 2
        if b_arr[mid] >= val:
            right = mid
        else:
            left = mid + 1
            
    if right == (len(b_arr) - 1) and val > b_arr[-1]:
            return right + 1
    
    return right
    

        
        
        
        