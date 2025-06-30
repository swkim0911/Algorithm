import sys
from collections import Counter

input = sys.stdin.readline

t = int(input().strip())

string_builder = ''

for _ in range(t):
    n = int(input().strip())
    teams = list(map(int, input().strip().split(' ')))
    counter = Counter(teams)  # 각 팀 당 몇명이 참가하는지 기록된 dict
    failed_teams = []  # 6명이 안되는 team들
    for k, v in counter.items():
        if v != 6:
            failed_teams.append(k)
    score = 1
    d = {}  # t:[x,y,z] -> t팀의 정보. [현재까지 팀 인원, 4번까지 합, 5번의 점수]
    for member in teams:
        if member in failed_teams:
            continue
        if member in d:
            info = d[member]
            info[0] += 1
            if info[0] < 5:
                info[1] += score
            elif info[0] == 5:
                info[2] = score

        else:  # 팀에서 첫번째인 경우
            info = [0] * 3
            info[0] += 1
            info[1] += score
            d[member] = info

        score += 1

    # 가장 낮은 점수 찾기
    min_value = float('inf')
    for info in d.values():
        if info[1] < min_value:
            min_value = info[1]

    # 가장 낮은 점수를 가진 팀 후보 찾기
    candidators = []
    for k, info in d.items():
        if info[1] == min_value:
            candidators.append(k)

    min_answer = float('inf')
    answer = 0
    # 후보중 5번째 주자가 가장 빨리 들어온 팀 선택
    for c in candidators:
        if d[c][2] < min_answer:
            min_answer = d[c][2]
            answer = c

    string_builder += str(answer) + '\n'

print(string_builder)
