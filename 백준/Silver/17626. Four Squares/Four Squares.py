import sys
import math

input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)

for x in range(1, n+1):
    min_count = float('inf')

    for i in range(1, int(math.isqrt(x)) + 1):
        min_count = min(min_count, dp[x - i * i])
    dp[x] = min_count + 1

print(dp[n])
