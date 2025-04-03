import sys
import heapq

input = sys.stdin.readline


class Task:
    def __init__(self, d, w):
        self.d = d
        self.w = w

    def __lt__(self, other):
        return self.w > other.w  # w기준 내림차순 정렬


n = int(input())

answer = 0
heap = []
max_day = -1

for i in range(n):
    d, w = map(int, input().split(' '))
    max_day = max(max_day, d)
    heapq.heappush(heap, Task(d, w))

check = [False] * (max_day+1)

while heap:
    task = heapq.heappop(heap)
    for d in range(task.d, 0, -1):
        if not check[d]:
            check[d] = True
            answer += task.w
            break

print(answer)

# 가장 점수가 높은 것들 부터 보면서 최대한 가장 늦게 끝내기.

# 4: 60 -> 4일
# 2: 50 -> 2일
# 4: 40 -> 3일
# 3: 30 -> 1일
# 1: 20 -> x
# 4: 10 -> x
# 6: 5 -> 6일
