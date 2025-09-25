def solution(s1, s2):
    answer = 0
    for one in s1:
        for two in s2:
            if one == two:
                answer += 1
                break
    return answer