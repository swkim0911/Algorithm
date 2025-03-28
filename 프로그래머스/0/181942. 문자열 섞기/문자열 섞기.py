def solution(str1, str2):
    answer = ''
    for i in range(len(str1)):
        answer += str1[i:i+1]
        answer += str2[i:i+1]
    return answer