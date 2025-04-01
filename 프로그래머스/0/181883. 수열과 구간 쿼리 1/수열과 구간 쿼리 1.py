def solution(arr, queries):
    for q in queries:
        s = q[0]
        e = q[1]
        for i in range(s,e+1):
            arr[i] += 1
    return arr