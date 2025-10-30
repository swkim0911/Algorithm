def solution(numbers, direction):

    if direction == "right":
        return [numbers[-1]] + numbers[: len(numbers) - 1]
    else:
        return numbers[1:] + [numbers[0]]