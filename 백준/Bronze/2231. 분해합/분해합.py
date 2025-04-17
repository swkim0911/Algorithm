
n = int(input())

answer = 0


def get_split_sum(num):
    sum = num
    for s in str(num):
        sum += int(s)

    return sum


for num in range(n, 0, -1):
    split_sum = get_split_sum(num)
    if split_sum == n:
        answer = num

print(answer)
