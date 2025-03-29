def solution(arr):
    answer = 0
    before = list(arr)
    while True:
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] /= 2
            elif arr[i] < 50 and arr[i] % 2 != 0:
                arr[i] = arr[i] * 2 + 1
        if before == arr: break
        answer += 1
        
        before = list(arr)
        
    return answer