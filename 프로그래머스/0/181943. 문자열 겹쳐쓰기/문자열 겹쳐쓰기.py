def solution(my_string, overwrite_string, s):
    answer = my_string[:s] + overwrite_string
    if s + len(overwrite_string) < len(my_string):
        answer += my_string[s + len(overwrite_string):]
    return answer