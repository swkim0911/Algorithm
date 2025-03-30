def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        m = 1_000_001
        for i in range(s,e+1):
            if arr[i] > k:
                m = min(m, arr[i])
        if m == 1_000_001:
            answer.append(-1)
        else:
            answer.append(m)        
    return answer