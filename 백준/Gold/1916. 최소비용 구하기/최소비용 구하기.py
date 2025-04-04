import sys
import heapq

input = sys.stdin.readline

INF = float('inf')

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    s, e, w = map(int, input().split(' '))
    graph[s].append((e, w))

start, end = map(int, input().split(' '))

heap = []
dist = [INF] * (n+1)
heapq.heappush(heap, (0, start))

while heap:
    d, v = heapq.heappop(heap)
    if dist[v] < d:
        continue

    for nxt_v, nxt_w in graph[v]:
        next_distance = d + nxt_w

        if next_distance < dist[nxt_v]:
            dist[nxt_v] = next_distance
            heapq.heappush(heap, (dist[nxt_v], nxt_v))

print(dist[end])


# 다익스트라
