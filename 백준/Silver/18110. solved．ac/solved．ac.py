import sys

input = sys.stdin.readline


def custom_round(x):
    return int(x + 0.5)


n = int(input().strip())
arr = [int(input().strip()) for _ in range(n)]

# 1. 정렬
arr.sort()

# 2. 상위 15%, 하위 15% 제외
exc = custom_round(n * 15 / 100)

sum = 0
for i in range(exc, n-exc):
    sum += arr[i]

answer = 0 if n == 0 else custom_round(sum / (n - 2*exc))

print(answer)
