def solution(arr1, arr2):
    answer = 0
    if len(arr1) > len(arr2):
        answer = 1
    elif len(arr1) < len(arr2):
        answer = -1
    else:
        s1 = sum(arr1)
        s2 = sum(arr2)
        if s1 == s2:
            answer = 0
        elif s1 > s2:
            answer = 1
        else: answer = -1
        
    return answer