arr = [c for c in input().strip()]
sum = 0
index = 0
for i, c in enumerate(arr):
    if c.isdigit():
        if i % 2 == 0:
            sum += int(c)
        else:
            sum += 3 * int(c)
    else:
        index = i

if sum % 10 == 0:
    print(0)
else:
    if index % 2 == 0:
        print(10 - (sum % 10))
    else:
        for x in range(10):
            if (sum + 3 * x) % 10 == 0:
                print(x)
                break
