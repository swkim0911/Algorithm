def solution(date1, date2):
    result = int(''.join(map(str,date1))) < int(''.join(map(str,date2)))
    
    return int(result)