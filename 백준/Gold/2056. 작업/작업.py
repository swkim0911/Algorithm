import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

graph = [[] for _ in range(n+1)]
works = [0] * (n+1)  # works[x]: x작업에 걸리는 시간
degrees = [0] * (n+1)  # degrees[x]: x작업 앞에 있어야 하는 작업 수
done = [0] * (n+1)  # done[x]: 작업이 끝나는 시간

for i in range(0, n):
    info = list(map(int, input().split(' ')))
    w = info[0]  # 작업에 걸리는 시간
    pre_cnt = info[1]  # 선행 관계에 있는 작업 수
    works[i+1] = w
    degrees[i+1] = pre_cnt

    for j in range(2, 2 + pre_cnt):
        graph[info[j]].append(i+1)

dq = deque()

for v in range(1, n+1):
    if degrees[v] == 0:
        dq.append(v)
        done[v] = works[v]


while dq:
    v = dq.popleft()

    for nxt in graph[v]:
        degrees[nxt] -= 1
        done[nxt] = max(done[nxt], done[v] + works[nxt])
        if degrees[nxt] == 0:
            dq.append(nxt)

print(max(done))
