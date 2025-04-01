def solution(arr):
    answer = 1
    r = len(arr)
    for i in range(r):
        for j in range(0,i+1):
            if arr[i][j] != arr[j][i]:
                answer = 0
                return 0
    return 1