def solution(my_string, m, c):
    answer = ''
    board = []
    for i in range(0,len(my_string), m):
        board.append(list(my_string[i:i+m]))
    for i in range(0, len(board)):
        answer += board[i][c-1]
    return answer