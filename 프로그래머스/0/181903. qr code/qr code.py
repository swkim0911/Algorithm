def solution(q, r, code):
    answer = ''
    for i,s in enumerate(code):
        if i % q == r:
            answer += s
    return answer