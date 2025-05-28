import sys

input = sys.stdin.readline

str = input().strip()

str = str.replace('XXXX', 'AAAA')
str = str.replace('XX', 'BB')

answer = -1 if 'X' in str else str

print(answer)
