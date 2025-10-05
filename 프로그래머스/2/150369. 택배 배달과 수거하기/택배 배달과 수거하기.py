def solution(cap, n, deliveries, pickups):
    answer = 0
    delivery = 0 # delivery < 0: 배달 공간 여유가 있는거
    pickup = 0 # pickup < 0: 수거 공간 여유가 있는거
    for i in range(n-1, -1, -1):
        delivery += deliveries[i]
        pickup += pickups[i]
        
        while delivery > 0 or pickup > 0:
            delivery -= cap
            pickup -= cap
            
            answer += (i+1) * 2
    
    return answer

# 그리디
