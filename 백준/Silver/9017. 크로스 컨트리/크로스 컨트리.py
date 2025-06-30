import sys
from collections import Counter, defaultdict

input = sys.stdin.readline

t = int(input().strip())

result = []

for _ in range(t):
    n = int(input())
    teams = list(map(int, input().split(' ')))
    counter = Counter(teams)  # 각 팀 당 몇명이 참가하는지 기록된 dict
    valid_teams = {team for team, count in counter.items() if count == 6}
    score = 1
    d = defaultdict(lambda: [0, 0, 0])  # [참가자 수, 1~4위 합계, 5위 점수]
    for member in teams:
        if member not in valid_teams:
            continue

        info = d[member]
        info[0] += 1
        if info[0] < 5:
            info[1] += score
        elif info[0] == 5:
            info[2] = score

        score += 1

    # 가장 낮은 점수 찾기
    min_sum = min(info[1] for info in d.values())

    # 가장 낮은 점수를 가진 팀 후보 찾기
    candidates = [team for team, info in d.items() if info[1] == min_sum]

    answer = min(candidates, key=lambda team: d[team][2])

    result.append(str(answer))

print('\n'.join(result))
