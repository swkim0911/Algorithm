import sys
import heapq

sys.setrecursionlimit(10**9)
input = sys.stdin.readline


class Data:
    def __init__(self, v1, v2, w):
        self.v1 = v1
        self.v2 = v2
        self.w = w

    def __lt__(self, other):
        return self.w < other.w


def get_parent(v, parents):
    if parents[v] == v:
        return v

    parents[v] = get_parent(parents[v], parents)
    return parents[v]


def same_group(v1, v2, parents):
    p1 = get_parent(v1, parents)
    p2 = get_parent(v2, parents)

    return p1 == p2


def union(v1, v2, parents):
    p1 = get_parent(v1, parents)
    p2 = get_parent(v2, parents)

    if p1 < p2:
        parents[p2] = p1
    else:
        parents[p1] = p2


heap = []
n = int(input())

for i in range(0, n):
    row = list(map(int, input().split(' ')))
    for j in range(i+1, n):
        heapq.heappush(heap, Data(i+1, j+1, row[j]))

parents = [i for i in range(n+1)]  # parents[x]: x의 부모 노드. 초기화: 자기 자신이 부모
answer = 0
cnt = 0
while cnt != n-1:
    cur = heapq.heappop(heap)

    if not same_group(cur.v1, cur.v2, parents):
        union(cur.v1, cur.v2, parents)
        cnt += 1
        answer += cur.w

print(answer)
