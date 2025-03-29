def solution(arr, n):
    answer = []
    if len(arr) % 2 == 1:
        for i in range(0, len(arr)):
            val = arr[i] + n if i % 2 == 0 else arr[i]
            answer.append(val)
    else:
        for i in range(0, len(arr)):
            val = arr[i] + n if i % 2 == 1 else arr[i]
            answer.append(val)
            
    return answer