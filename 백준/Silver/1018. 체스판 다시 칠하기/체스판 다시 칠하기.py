import sys


def getCnt(color, board, r, c):

    cnt = 0
    for i in range(r, r + 8):
        for j in range(c, c + 8):
            if color != board[i][j]:
                cnt += 1
            if j != c + 7:
                color = 'B' if color == 'W' else 'W'

    return cnt


def printBoard(board, r, c):
    for i in range(r, r + 8):
        for j in range(c, c + 8):
            print(board[i][j], end='')
        print()


m, n = map(int, sys.stdin.readline().strip().split(' '))
board = []
for i in range(m):
    board.append(list(sys.stdin.readline().strip()))

answer = 5000
# r,c 시작 위치
for r in range(0, m-7):
    for c in range(0, n-7):
        # 시작이 w,b인 경우 비교
        cnt1 = getCnt('W', board, r, c)
        cnt2 = getCnt('B', board, r, c)
        answer = min(answer, min(cnt1, cnt2))


print(answer)
