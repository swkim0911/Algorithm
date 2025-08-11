t = int(input())

for _ in range(t):
    n, d = map(int, input().split(' '))
    cnt = 0
    for _ in range(n):
        v, f, c = map(int, input().split(' '))
        time = d / v
        if time * c <= f:
            cnt += 1
    print(cnt)


# 연료와 목적지까지의 도착시간
# 최고속도와 연료소비율. 연료 소비율은 단위시간당 소비하는 연료의 양

# 목적지까지 거리:100
# 최고속도: 52, 연료양: 75, 연료소비율:10

# 모든 우주선이 최고속도에 즉시 도달.

# 거 / 속 * 시
# 연료소비율 10: 1시간당 10 소요.
# 시간 = 100 / 52
