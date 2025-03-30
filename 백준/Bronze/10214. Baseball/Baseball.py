import sys
t = int(sys.stdin.readline())
while t > 0:
    y = 0
    k = 0
    for _ in range(9):
        y_score, k_score = map(int, sys.stdin.readline().split(' '))
        y += y_score
        k += k_score
    if y > k:
        print('Yonsei')
    elif y < k:
        print('Korea')
    else:
        print('Draw')

    t -= 1
