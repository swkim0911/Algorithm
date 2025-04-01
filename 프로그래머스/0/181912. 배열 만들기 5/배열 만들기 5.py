def solution(intStrs, k, s, l):
    answer = []
    for string in intStrs:
        sub_str = string[s:s+l]
        if int(sub_str) > k:
            # print(sub_str)
            answer.append(int(sub_str))
    return answer