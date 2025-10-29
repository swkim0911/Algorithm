def solution(park, routes):
    answer = []
    row_len = len(park)
    col_len = len(park[0])
    cur = [0,0]
        
    for i, row in enumerate(park):
        if "S" in row:
            cur = [i, row.index("S")]
            break
    
    for route in routes:
        op,n = route.split(" ")
        n = int(n)
        if op == "N": # 북
            # 경계 밖인지 확인
            if cur[0] - n < 0:
                continue
            # 장애물을 만나는지 확인
            isBlocked = False
            for i in range(cur[0] - 1, cur[0] - n - 1, -1):
                if park[i][cur[1]] == "X":
                    isBlocked = True
                    break;
            if not isBlocked:
                cur[0] -= n
        elif op == "S": # 남
            if cur[0] + n >= row_len:
                continue
            isBlocked = False
            for i in range(cur[0] + 1, cur[0] + n + 1):
                if park[i][cur[1]] == "X":
                    isBlocked = True
                    break;
            if not isBlocked:
                cur[0] += n
        elif op == "W": # 서
            if cur[1] - n < 0:
                continue
            isBlocked = False
            for j in range(cur[1] - 1, cur[1] - n - 1, -1):
                if park[cur[0]][j] == "X":
                    isBlocked = True
                    break;
        
            if not isBlocked:
                cur[1] -= n
        elif op == "E": # 동
            if cur[1] + n >= col_len:
                continue
            isBlocked = False
            for j in range(cur[1] + 1, cur[1] + n + 1):
                if park[cur[0]][j] == "X":
                    isBlocked = True
                    break;
            if not isBlocked:
                cur[1] += n
    
    return cur


# soo
# oxx
# ooo