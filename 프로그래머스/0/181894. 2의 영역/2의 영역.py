def solution(arr):
    two_arr = []
    for i,n in enumerate(arr):
        if n == 2:
            two_arr.append(i)
    if not two_arr:
        return [-1]
    else:
        s = two_arr[0]
        e = two_arr[-1]
        return arr[s:e+1]