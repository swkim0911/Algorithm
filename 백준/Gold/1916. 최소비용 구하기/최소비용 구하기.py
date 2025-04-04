import sys
import heapq

input = sys.stdin.readline
INF = float('inf')

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, d = map(int, input().split())
    graph[s].append((e, d))  # (목적지, 거리) 튜플 저장

start, end = map(int, input().split())

# 다익스트라 알고리즘
pq = []
dist = [INF] * (n + 1)
dist[start] = 0
heapq.heappush(pq, (0, start))  # (거리, 노드) 형태로 저장

while pq:
    cur_dist, cur_node = heapq.heappop(pq)
    
    if dist[cur_node] < cur_dist:
        continue
    
    for next_node, next_dist in graph[cur_node]:
        new_distance = cur_dist + next_dist
        if new_distance < dist[next_node]:
            dist[next_node] = new_distance
            heapq.heappush(pq, (new_distance, next_node))

print(dist[end])
