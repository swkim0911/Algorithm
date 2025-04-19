import sys

input = sys.stdin.readline

s1 = input().strip()
s2 = input().strip()
s3 = input().strip()

s4 = 0
if s1.isdigit():
    s4 = int(s1) + 3
elif s2.isdigit():
    s4 = int(s2) + 2
elif s3.isdigit():
    s4 = int(s3) + 1

if s4 % 3 == 0 and s4 % 5 == 0:
    print('FizzBuzz')
elif s4 % 3 == 0:
    print('Fizz')
elif s4 % 5 == 0:
    print('Buzz')
else:
    print(s4)
