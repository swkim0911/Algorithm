def solution(cap, n, deliveries, pickups):
    answer = 0
    remain_delivery = 0
    remain_pickup = 0
    for i in range(n-1, -1, -1):
        remain_delivery += deliveries[i]
        remain_pickup += pickups[i]
        
        while remain_delivery > 0 or remain_pickup > 0:
            remain_delivery -= cap
            remain_pickup -= cap
            answer += (i+1) * 2
    return answer