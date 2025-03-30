def solution(num_list):
    even = 0
    odd = 0
    for i in range(0, len(num_list)):
        if i % 2 == 0:
            odd += num_list[i]
        else:
            even += num_list[i]
    return max(even, odd)