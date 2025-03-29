def solution(a, d, included):
    val = a
    answer = 0
    for b in included:
        if b:
            answer += val
        val += d
    return answer