import sys
t = int(input())
answer = ''
while t > 0:
    n = int(input())
    arr = []
    for _ in range(n):
        tmp = input().split(' ')
        tmp[1] = int(tmp[1])
        arr.append(tmp)
    t -= 1

    arr.sort(key=lambda x: x[1], reverse=True)
    answer += arr[0][0] + "\n"

print(answer.strip())
