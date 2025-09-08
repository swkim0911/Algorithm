
answer = 0

def solution(n, q, ans):
    dfs(n,q, ans, [], 1)
    return answer



def dfs(n, queries, ans, arr, start):
    
    if len(arr) == 5:
        for i, q in enumerate(queries):
            cnt = len(set(arr) & set(q))
            if ans[i] != cnt:
                return
        global answer
        answer += 1        
        return
        
    
    for i in range(start, n + 1):
        dfs(n, queries, ans, arr + [i], i + 1)
    
    
    

# 모든 정수 조합에 대해서 조건을 만족하는지 확인