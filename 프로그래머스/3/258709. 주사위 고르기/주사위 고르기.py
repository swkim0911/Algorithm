from itertools import combinations

def solution(dice):
    answer = []
    n = len(dice)
    idx_set = set(range(n))
    
    max_wins = -1
    
   
    for comb in combinations(range(n), n // 2):
        # 1. a와 b가 선택할 수 있는 조합
        a_comb = list(comb)
        b_comb = list(idx_set - set(comb))
    
        # 2. a의 주사위 조합에서 가능한 모든 경우 6^(n//2)    
        # 3. b의 주사위 조합에서 가능한 모든 경우
        a_results = []
        b_results = []
        for i in range(6**(n//2)):
            cur = i
            a_total = 0
            b_total = 0
            for j in range(n//2):
                rest = cur % 6
                a_total += dice[a_comb[j]][rest]
                b_total += dice[b_comb[j]][rest]
                cur //= 6
                
            a_results.append(a_total)
            b_results.append(b_total)
        
        
        # 오름차순 정렬
        a_results.sort()
        b_results.sort()
        
        a_wins = 0
        # a의 각 결과에 대해 바이너리 서치로 얼마큼 이길 수 있는지 확인한다 (log n)
        for a_result in a_results:
            a_win = binary_search(a_result, b_results)
            a_wins += a_win
        if a_wins > max_wins:
            max_wins = a_wins
            answer = a_comb
    
    answer = [x + 1 for x in answer]

    return answer


# a_result보다 작지 않는 첫번쨰 index찾기
def binary_search(a_result, b_results):
    n = len(b_results)
    left = 0
    right = n - 1
    while left < right:
        mid = (left + right) // 2;
        if b_results[mid] >= a_result:
            right = mid
        else:
            left = mid + 1
    if right == n - 1:
        if a_result > b_results[-1]:
            return right + 1
        
    return right

        