def solution(rsp_arr):
    answer = ''
    wins = {"2":"0", "0":"5", "5":"2"}
    for rsp in rsp_arr:
        answer += wins[rsp]
    
    return answer