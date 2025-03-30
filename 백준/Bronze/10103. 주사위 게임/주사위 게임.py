import sys
n = int(sys.stdin.readline())
a = 100
b = 100
for _ in range(n):
    a_score, b_score = map(int, sys.stdin.readline().split(' '))
    if a_score < b_score:
        a -= b_score
    elif a_score > b_score:
        b -= a_score

print(f"{a}\n{b}")