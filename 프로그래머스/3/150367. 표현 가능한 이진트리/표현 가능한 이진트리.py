import sys
sys.setrecursionlimit(10**9)

def solution(numbers):
    answer = []
    
    for number in numbers:
        binary_num = []
        # 1. 2**n - 1 크기의 2진수 만들기
        while number != 0:
            rest = number % 2
            binary_num.append(rest)
            number //= 2
        binary_num = binary_num[::-1]
          
        exp = 1
        while True:
            length = 2**exp - 1
            if len(binary_num) <= length:
                gap = length - len(binary_num)
                binary_num = [0] * gap + binary_num
                break
            exp += 1
        # print(binary_num)
        if is_binary_tree(binary_num):
            answer.append(1)
        else:
            answer.append(0)
         # 2. 배열로 표현되는 이진수에서 가능한 이진수 형태인지 아닌지 확인하기
    
    return answer

# 서브 트리 루트가 1이면 좌우에 있을 수 있는데 0이면 절대 안됨
def is_binary_tree(binary_num):
    if len(binary_num) == 1:
        return True
    
    root_idx = len(binary_num) // 2
    if binary_num[root_idx] != 1 and (1 in binary_num[0:root_idx] or 1 in binary_num[root_idx+1:]):
        return False
    # root 1이면 서브트리 마져 확인
    
    left_subtree_result = is_binary_tree(binary_num[:root_idx])
    right_subtree_result = is_binary_tree(binary_num[root_idx+1:])
    
    return left_subtree_result and right_subtree_result
    
    

# [1]
# [1,1,1]
# [1,1,1,1,1,1,1]
# [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

# 트리(서브트리)에 루트가 없으면 만들어질 수 없음




# 1.정수 -> 2진수 -> 포화 2^n-1 길이로 맞추기 


