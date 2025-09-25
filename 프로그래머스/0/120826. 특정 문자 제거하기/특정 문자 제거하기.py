def solution(my_string, letter):
    answer = ''.join( s for s in my_string if s != letter)

    return answer