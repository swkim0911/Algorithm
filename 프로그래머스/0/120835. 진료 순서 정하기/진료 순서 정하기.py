def solution(emergency):
    arr = sorted(emergency, reverse=True)
    answer = []
    for e in emergency:
        for i, v in enumerate(arr):
            if e == v:
                answer.append(i+1)
                break
                
    return answer