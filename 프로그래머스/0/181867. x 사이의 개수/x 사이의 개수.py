def solution(myString):
    arr = myString.split('x')
    answer = []
    for s in arr:
        answer.append(len(s))
    return answer