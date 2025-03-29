def solution(myString, pat):
    text = ''
    for s in myString:
        if s == 'A':
            text += 'B'
        else:
            text += 'A'
    
    return int(pat in text)