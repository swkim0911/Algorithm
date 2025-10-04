def solution(cap, n, deliveries, pickups):
    answer = 0
    remain_d = 0
    remain_p = 0

    for i in range(n-1, -1, -1):
        remain_d += deliveries[i]
        remain_p += pickups[i]

        while remain_d > 0 or remain_p > 0:
            remain_d -= cap
            remain_p -= cap
            answer += (i+1) * 2

    return answer
