import sys

input = sys.stdin.readline

a, b, v = map(int, input().strip().split(' '))

time = 1

v -= a

t = v // (a - b) if v % (a - b) == 0 else v // (a - b) + 1
time += t

print(time)
