def solution(dot):
    x,y = dot
    if x * y > 0:
        if x > 0:
            return 1
        else:
            return 3
    else:
        if x > 0:
            return 4
        else:
            return 2
            