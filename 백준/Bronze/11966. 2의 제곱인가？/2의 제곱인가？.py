n = int(input())

arr = [2**i for i in range(0, 31)]

if n in arr:
    print(1)
else:
    print(0)
