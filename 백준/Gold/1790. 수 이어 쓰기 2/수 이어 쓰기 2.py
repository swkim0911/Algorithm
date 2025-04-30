import sys

input = sys.stdin.readline

n, k = map(int, input().strip().split(' '))

digit = 1  # 자리수

while k > 9 * (10 ** (digit - 1)) * digit:
    k -= 9 * (10 ** (digit - 1)) * digit
    digit += 1

count = (k-1) // digit
number = 10**(digit - 1) + count
idx = (k-1) % digit

answer = -1 if number > n else str(number)[idx]

print(answer)
