import sys

input = sys.stdin.readline

l = int(input().strip())
str = input().strip()

answer = 0

for i, s in enumerate(str):
    n = ord(s) - ord('a') + 1
    answer += n * (31**i)

print(answer % 1234567891)
