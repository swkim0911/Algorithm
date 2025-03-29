def solution(schedules, timelogs, startday):
    answer = 0
    
    for i in range(len(schedules)):
        timelog = timelogs[i]
        
        minute = schedules[i] % 100
        hour = (schedules[i] - minute) / 100
        minute += 10
        if minute >= 60:
            hour += 1
            minute -= 60
        deadline = hour * 100 + minute
        
        day = startday
        for time in timelog:
            
            if day % 7 == 0 or day % 7 == 6:
                day += 1
                continue
                
            if time > deadline: break # 시간을 넘은 경우
            
            day += 1
            
        if day == startday + 7:
            answer += 1
        
    return answer

