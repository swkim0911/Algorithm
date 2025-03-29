def solution(num_list):
    last = num_list[len(num_list)-1]
    llast = num_list[len(num_list) - 2]
    if llast < last:
        num_list.append(last - llast)
    else:
        num_list.append(last*2)
                
    return num_list