def solution(board, k):
    answer = 0
    r = len(board)
    c = len(board[0])
    for i in range(r):
        for j in range(c):
            if i + j <= k:
                answer += board[i][j]
    return answer