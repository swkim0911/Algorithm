import sys

input = sys.stdin.readline

n = int(input().strip())

dp = [0] * (1_000_001)
dp[1] = 1
dp[2] = 2
for i in range(3, len(dp)):
    dp[i] = dp[i-1] + dp[i-2]
    dp[i] %= 15746

print(dp[n])
