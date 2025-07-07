import sys

input = sys.stdin.readline

n, k = map(int, input().split(' '))

arr = list(input())
visited = [False] * n

for i, v in enumerate(arr):
    if v == 'P':
        s = i - k if i - k >= 0 else 0
        e = i + k if i + k < n else n - 1
        for nxt in range(s, e + 1):
            if nxt == i:
                continue
            if arr[nxt] == 'H' and not visited[nxt]:
                visited[nxt] = True
                break

answer = sum(visited)

print(answer)
