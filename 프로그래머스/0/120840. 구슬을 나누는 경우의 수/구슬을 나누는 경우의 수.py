def solution(balls, share):
    answer = comb(balls, share)
    return answer

def comb(n,m):
    val = 1
    for i in range(1, m + 1):
        val *= (n - i + 1);
        val //= i
    
    return val