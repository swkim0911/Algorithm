def solution(arr):
    answer = []
    for n in arr:
        answer += [n] * n
    return answer