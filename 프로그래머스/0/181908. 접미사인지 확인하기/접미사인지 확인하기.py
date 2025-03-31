def solution(my_string, is_suffix):
    answer = 0
    print(my_string[-len(is_suffix):])
    return int(my_string[-len(is_suffix) :] == is_suffix)