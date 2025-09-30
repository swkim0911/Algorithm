from collections import defaultdict

def solution(friends, gifts):
    answer = 0
    friend_relation = defaultdict(int)  # 선물 기록에 있는 관계 
    gift_score = defaultdict(int) # 선물 지수
    
    all_relation = set() # 모든 관계 집합
    for i in range(0, len(friends)):
        for j in range(i+1, len(friends)):
            all_relation.add(friends[i]+" "+friends[j])
    
    for gift in gifts:
        friend_relation[gift] += 1
        a,b = gift.split(" ")
        gift_score[a] += 1
        gift_score[b] -= 1
            
    total_gifts = dict() # 정답 dict
    for friend in friends:
        total_gifts[friend] = 0
    
    for a_to_b in all_relation:
        a, b = a_to_b.split(" ")
        b_to_a = b+" "+a
        if (a_to_b not in friend_relation) and (b_to_a not in friend_relation): # 두 사람이 선물 주고 받은 기록이 없는 경우
            if gift_score[a] > gift_score[b]:
                total_gifts[a] += 1
            elif gift_score[a] < gift_score[b]:
                total_gifts[b] += 1
            continue
        a_to_b_score = friend_relation[a_to_b] if friend_relation[a_to_b] else 0
        b_to_a_score = friend_relation[b_to_a] if friend_relation[b_to_a] else 0
        if a_to_b_score > b_to_a_score:
            total_gifts[a] += 1
        elif a_to_b_score < b_to_a_score:
            total_gifts[b] += 1
        else:
            if gift_score[a] > gift_score[b]:
                total_gifts[a] += 1
            elif gift_score[a] < gift_score[b]:
                total_gifts[b] += 1
    
    answer = max(total_gifts.values())
        
        
    
    return answer


## 각 친구들간의 관계
## a -> b, b -> a, c -> a, a->c, a->c, c->a
## a는 b에게 1
## a는 c에게 2
## b는 a에게 1
## c는 a에게 2

## 선물 지수
# a: 0
# b: 0
# c: 0

