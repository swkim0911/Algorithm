n = int(input())
arr = list(map(int, input().split(' ')))
t, p = map(int, input().split(' '))

total = 0
for x in arr:
    total += x // t if x % t == 0 else x // t + 1

cnt = n // p
rest = n % p
print(total)
print(f'{cnt} {rest}')
