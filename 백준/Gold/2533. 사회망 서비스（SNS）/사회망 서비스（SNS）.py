import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split(' '))
    tree[u].append(v)
    tree[v].append(u)

# dp[x][0]: x가 얼리 어답터가 아닐 때, 얼리 어답터 수, dp[x][1]: x가 얼리 어답터일 때, 얼리 어답터 수
dp = [[0, 0] for _ in range(n+1)]
visited = [False] * (n+1)


def dfs(node):
    visited[node] = True
    dp[node][1] = 1

    for nxt in tree[node]:
        if not visited[nxt]:
            dfs(nxt)
            dp[node][0] += dp[nxt][1]
            dp[node][1] += min(dp[nxt][0], dp[nxt][1])


dfs(1)

print(min(dp[1][0], dp[1][1]))
