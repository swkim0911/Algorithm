import sys

input = sys.stdin.readline

n, m = map(int, input().strip().split())
dp = [[0] * (m+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(0, min(i+1, m+1)):
        if j == 0:
            dp[i][j] = 1
        elif i == j:
            dp[i][j] = 1
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

print(dp[n][m])
