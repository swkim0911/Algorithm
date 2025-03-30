def solution(arr, queries):
    answer = []
    for q in queries:
        i = q[0]
        j = q[1]
        # swap
        tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
        
    return arr