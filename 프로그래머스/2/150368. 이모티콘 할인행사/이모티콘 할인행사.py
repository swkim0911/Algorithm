import sys

sys.setrecursionlimit(10**9)


def solution(users, emoticons):
    rates = [10,20,30,40]
    answer = []
    
    max_plus_service = -1
    max_users_play = 0
    # 4 ** 7
    for v in range(4**len(emoticons)):
        cur = v
        rate_arr = []
        plus_service = 0
        users_pay = 0
        
        for i in range(len(emoticons)):
            rest = cur % 4
            rate_arr.append(rates[rest])
            cur //= 4
        
        for user in users:
            user_rate, price_limit = user
            user_pay = 0
            for i, rate in enumerate(rate_arr):
                if user_rate <= rate:
                    user_pay += emoticons[i] * (100 - rate) // 100
            if price_limit <= user_pay:
                plus_service += 1
            else:
                users_pay += user_pay
        
        if max_plus_service < plus_service:
            max_plus_service = plus_service
            max_users_play = users_pay
        elif max_plus_service == plus_service and max_users_play < users_pay:
            max_plus_service = plus_service
            max_users_play = users_pay

    return [max_plus_service, max_users_play]

# 이모티콘 플러스 가입자를 최대로 늘리면서 + 이모티콘 판매액일 최대한으로 늘리기

# 이모티콘 할인율: 10,20,30,40

