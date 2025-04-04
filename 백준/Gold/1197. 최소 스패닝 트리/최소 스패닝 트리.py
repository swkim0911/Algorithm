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


def is_diff_group(v1, v2, parents):
    p1 = get_parent(v1, parents)
    p2 = get_parent(v2, parents)

    return p1 != p2


def union(v1, v2, parents):
    p1 = get_parent(v1, parents)
    p2 = get_parent(v2, parents)
    if p1 < p2:
        parents[p2] = p1
    else:
        parents[p1] = p2


heap = []
v, e = map(int, input().split(' '))

for _ in range(e):
    a, b, c = map(int, input().split(' '))
    heapq.heappush(heap, Data(a, b, c))

parents = [i for i in range(0, v+1)]  # parents[x]: x의 부모 노드. 초기화: 자기 자신 노드

answer = 0
cnt = 0
while cnt != v-1:
    cur = heapq.heappop(heap)

    if is_diff_group(cur.v1, cur.v2, parents):
        union(cur.v1, cur.v2, parents)
        answer += cur.w
        cnt += 1

print(answer)
