import math
def solution(price):
    answer = 0
    if price >= 500_000:
        answer = math.floor(price * 80 / 100)
    elif price >= 300_000:
        answer = math.floor(price * 90 / 100)
    elif price >= 100_000:
        answer = math.floor(price * 95 / 100)
    else: 
        answer = price
    
    return answer