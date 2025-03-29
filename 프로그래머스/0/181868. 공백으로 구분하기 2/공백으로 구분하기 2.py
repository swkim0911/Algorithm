def solution(my_string):
    answer = []
    arr = my_string.split(' ')
    for s in arr:
        if s.strip():
            answer.append(s)
    return answer