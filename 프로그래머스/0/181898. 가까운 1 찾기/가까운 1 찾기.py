def solution(arr, idx):
    sub_arr = arr[idx:]
    answer = 0
    if 1 not in sub_arr:
        answer = -1
    else:
        answer = sub_arr.index(1) + idx
    return answer