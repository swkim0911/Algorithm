import sys


def is_pal(s):
    return s == s[::-1]


def solve(s):
    left = 0
    right = len(s) - 1
    while left < right:
        if s[left] == s[right]:
            left += 1
            right -= 1
        else:
            sub_str = s[:right] + s[right+1:]
            if is_pal(sub_str):
                return 1

            sub_str = s[:left] + s[left+1:]
            if is_pal(sub_str):
                return 1
            return 2

    return 0


answer = ''
t = int(sys.stdin.readline().strip())
for _ in range(t):
    s = sys.stdin.readline().strip()
    answer += str(solve(s)) + "\n"

print(answer)
