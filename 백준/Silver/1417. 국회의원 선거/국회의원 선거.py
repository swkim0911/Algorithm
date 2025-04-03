import sys
import heapq
input = sys.stdin.readline

max_heap = []
n = int(input())
number_one = 0

for i in range(n):
    m = int(input())
    if i == 0:
        number_one = m
    else:
        heapq.heappush(max_heap, -m)
answer = 0

while max_heap:
    number_max = -heapq.heappop(max_heap)
    if number_one > number_max:
        break
    number_one += 1
    number_max -= 1
    answer += 1
    heapq.heappush(max_heap, -number_max)

print(answer)
