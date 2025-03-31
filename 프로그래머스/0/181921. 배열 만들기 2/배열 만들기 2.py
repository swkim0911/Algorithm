def solution(l, r):
    answer = []
    for n in range(l, r+1):
        s = str(n)
        s = s.replace('0','')
        s = s.replace('5','')
        if not s:
            answer.append(n)
    return [-1] if not answer else answer