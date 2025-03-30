a, b, c = map(int, input().split(' '))
d = int(input())  # 초

h = d // (60*60)
d %= (60*60)
m = d // 60
d %= (60)
s = d

s += c
if s >= 60:
    s -= 60
    m += 1

m += b
if m >= 60:
    m -= 60
    h += 1

h += a
if h >= 24:
    h %= 24

print(f"{h} {m} {s}")
