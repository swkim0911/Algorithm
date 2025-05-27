import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().strip().split()))

prefix_sum = 0
answer = 0
for i in range(n-2, -1, -1):
    prefix_sum += arr[i+1]
    answer += arr[i] * prefix_sum

print(answer)
