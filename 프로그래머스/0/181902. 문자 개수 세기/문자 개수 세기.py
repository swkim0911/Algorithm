def solution(my_string):
    lower = [0] * 26
    upper = [0] * 26
    for s in my_string:
        if ord(s) <= ord('Z'):
            upper[ord(s) - ord('A')] += 1
        else:
            lower[ord(s) - ord('a')] += 1
    return upper + lower