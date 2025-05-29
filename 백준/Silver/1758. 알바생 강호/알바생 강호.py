import sys

input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

asc_arr = sorted(arr)
desc_arr = sorted(arr, reverse=True)

asc_sum = 0
desc_sum = 0
for i, x in enumerate(asc_arr):
    score = x - i
    if score > 0:
        asc_sum += score

for i, x in enumerate(desc_arr):
    score = x - i
    if score > 0:
        desc_sum += score

answer = max(asc_sum, desc_sum)
print(answer)
