def solution(commands):
    category_board = [[ "" for _ in range(51) ] for _ in range(51)]
    group_board = [ [[] for _ in range(51)] for _ in range(51)] # group_board[i][j]: (i,j) 위치 카테고리의 group list
    for i in range(1,51):
        for j in range(1,51):
            group_board[i][j].append((i,j))
    
    answer = []
    
    for command in commands:
        op = command.split(" ")[0]
        if op == "UPDATE":
            if len(command.split(" ")) == 4:
                r, c, value = int(command.split(" ")[1]), int(command.split(" ")[2]), command.split(" ")[3]
                
                category_board[r][c] = value
                for g_r, g_c in group_board[r][c]:
                    category_board[g_r][g_c] = value
            else:
                value1, value2 = command.split(" ")[1:]
                for i in range(1, 51):
                    for j in range(1,51):
                        if category_board[i][j] == value1:
                            category_board[i][j] = value2
                
        elif op == "MERGE":
            r1, c1, r2, c2 = map(int, command.split(" ")[1:])
            if r1 == r2 and c1 == c2:
                continue
            if (r2, c2) in group_board[r1][c1] or (r1, c1) in group_board[r2][c2]: # 이미 머지된 경우(선택한 두 위치의 셀이 같은 셀인 경우)
                continue
            if category_board[r1][c1] != "" and category_board[r2][c2] != "":
                ## (r2,c2) -> (r1,c1)  카테고리 변경
                for g_r, g_c in group_board[r2][c2]: 
                    category_board[g_r][g_c] = category_board[r1][c1]
            elif category_board[r1][c1] != "":
                for g_r, g_c in group_board[r2][c2]: 
                    category_board[g_r][g_c] = category_board[r1][c1]
            elif category_board[r2][c2] != "":
                for g_r, g_c in group_board[r1][c1]: 
                    category_board[g_r][g_c] = category_board[r2][c2]
            group_board[r1][c1] += group_board[r2][c2]
            for g_r, g_c in group_board[r1][c1]:
                group_board[g_r][g_c] = group_board[r1][c1][:]
            
        elif op == "UNMERGE":
            r, c = map(int, command.split(" ")[1:])
            
            for g_r, g_c in group_board[r][c]:
                if g_r == r and g_c == c: continue
                group_board[g_r][g_c] = [(g_r, g_c)]
                category_board[g_r][g_c] = ""
            group_board[r][c] = [(r,c)]
            
            
        elif op == "PRINT": ## print
            r, c = int(command.split(" ")[1]), int(command.split(" ")[2])
            answer.append("EMPTY" if category_board[r][c] == "" else category_board[r][c])
        # if command == "MERGE 2 1 1 1":
        #     for i in range(1,3):
        #         for j in range(1,3):
        #             print(group_board[i][j])
        # for i in range(1, 5):
        #     for j in range(1, 5):
        #         print("x" if category_board[i][j] == "" else category_board[i][j], end=" ")
        #     print("")
        # print("===")
        
        
    return answer

