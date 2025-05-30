import sys

input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

arr.sort(reverse=True)

answer = 0
for i, x in enumerate(arr):
    if i % 3 != 2:

        answer += x


print(answer)
