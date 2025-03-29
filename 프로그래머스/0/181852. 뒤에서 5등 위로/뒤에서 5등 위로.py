def solution(num_list):
    num_list.sort()
    answer = []
    for n in num_list[5:]:
        answer.append(n)
    return answer