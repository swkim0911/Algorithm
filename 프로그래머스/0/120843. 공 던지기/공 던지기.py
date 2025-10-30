def solution(numbers, k):
    numbers = numbers * k
    return numbers[(k-1)*2]