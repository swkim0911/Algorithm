def solution(code):
    mode = 0
    answer = ''
    
    for i in range(len(code)):
        if code[i] != '1':
            if mode == 0 and i % 2 == 0:
                answer += code[i]
            if mode == 1 and i % 2 == 1:
                answer += code[i]
        else:
            mode = 1 if mode == 0 else 0
    
    answer = 'EMPTY' if answer == '' else answer
    return answer 