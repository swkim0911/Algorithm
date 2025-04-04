import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split(' '))

graph = [[] for _ in range(n+1)]
degrees = [0] * (n+1)
dq = deque()

for _ in range(m):
    a, b = map(int, input().split(' '))
    degrees[b] += 1
    graph[a].append(b)

for i in range(1, n+1):
    if degrees[i] == 0:
        dq.append(i)

answer = []
while dq:
    cur = dq.popleft()
    answer.append(cur)
    for nxt in graph[cur]:
        degrees[nxt] -= 1
        if degrees[nxt] == 0:
            dq.append(nxt)

print(' '.join(map(str, answer)))