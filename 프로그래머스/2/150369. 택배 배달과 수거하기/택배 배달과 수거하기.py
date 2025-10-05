def solution(cap, n, deliveries, pickups):
    answer = 0
    deliver_stack = []
    pickup_stack = []

    # 1️⃣ 스택에 (집 번호, 개수) 저장 (0인 집은 제외)
    for i in range(n):
        if deliveries[i] > 0:
            deliver_stack.append((i + 1, deliveries[i]))
        if pickups[i] > 0:
            pickup_stack.append((i + 1, pickups[i]))

    # 2️⃣ 뒤에서부터 처리
    while deliver_stack or pickup_stack:
        # 현재 가장 먼 집 위치 (둘 중 더 먼 곳)
        farthest = 0
        if deliver_stack:
            farthest = max(farthest, deliver_stack[-1][0])
        if pickup_stack:
            farthest = max(farthest, pickup_stack[-1][0])

        answer += farthest * 2  # 왕복 거리 더하기

        # 3️⃣ 배달 처리
        deliver_capacity = cap
        while deliver_stack and deliver_capacity > 0:
            house, boxes = deliver_stack[-1]
            if boxes <= deliver_capacity:
                deliver_capacity -= boxes
                deliver_stack.pop()
            else:
                deliver_stack[-1] = (house, boxes - deliver_capacity)
                deliver_capacity = 0

        # 4️⃣ 수거 처리
        pickup_capacity = cap
        while pickup_stack and pickup_capacity > 0:
            house, boxes = pickup_stack[-1]
            if boxes <= pickup_capacity:
                pickup_capacity -= boxes
                pickup_stack.pop()
            else:
                pickup_stack[-1] = (house, boxes - pickup_capacity)
                pickup_capacity = 0

    return answer
