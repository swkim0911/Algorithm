import sys

input = sys.stdin.readline

n = int(input().strip())

answer = -1

five = n // 5

while five >= 0:
    rest = n - (5 * five)
    if rest % 2 == 0:
        one = rest // 2
        answer = five + one
        break
    five -= 1

print(answer)
