import sys

input = sys.stdin.readline

n, k = map(int, input().split(' '))

# 1. 몇 번째 자리수인지 확인
digit = 1  # 자리수
count = 9
total = 0
start = 1  # 시작 수

while k > total + digit * count:
    total += digit * count
    digit += 1
    count *= 10
    start *= 10

offset = k - total - 1
part_of_number = offset // digit
number = start + part_of_number
pos = offset % digit

answer = str(number)[pos] if n >= number else -1

print(answer)
