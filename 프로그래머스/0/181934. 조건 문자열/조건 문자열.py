def solution(ineq, eq, n, m):
    answer = 0
    if ineq == '>':
        if eq == '=':
            if n >= m: answer = 1
            else: answer = 0
        elif eq == '!':
            if n > m: answer = 1
            else: answer = 0
    elif ineq == '<':
        if eq == '=':
            if n <= m: answer = 1
            else: answer = 0
        elif eq == '!':
            if n < m: answer = 1
            else: answer = 0
    return answer