def solution(num_list, n):
    answer = 0
    for x in num_list:
        if x == n:
            answer = 1
            break
            
    return answer