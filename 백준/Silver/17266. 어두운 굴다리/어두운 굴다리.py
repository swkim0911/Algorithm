import sys

input = sys.stdin.readline

# 모든 굴다리를 밝힐 수 있는지 확인하는 함수


def is_possible(h, positions, n, m):
    if h < positions[0]:
        return False

    for i in range(1, m):
        if positions[i] - positions[i-1] > 2 * h:
            return False

    if n - positions[-1] > h:
        return False

    return True


n = int(input())
m = int(input())
positions = list(map(int, input().split(' ')))

left = 1
right = n

while left < right:
    mid = (left + right) // 2

    if is_possible(mid, positions, n, m):
        right = mid
    else:
        left = mid + 1


print(right)
