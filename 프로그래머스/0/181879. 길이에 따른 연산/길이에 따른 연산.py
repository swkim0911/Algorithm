def solution(num_list):
    answer = 0
    if len(num_list) > 10:
        answer = sum(num_list)
    else:
        tmp = 1
        for n in num_list:
            tmp *= n
        answer = tmp
    return answer