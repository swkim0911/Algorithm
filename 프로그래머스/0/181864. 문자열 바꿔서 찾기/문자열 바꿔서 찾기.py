def solution(myString, pat):
    text = myString.translate(str.maketrans('AB','BA'))
    
    return int(pat in text)