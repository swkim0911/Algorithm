def solution(today, terms, privacies):
    answer = []
    term_dict = {}
    for term in terms:
        term_type, exp = term.split(" ")
        term_dict[term_type] = int(exp)

    for i, privacy in enumerate(privacies):
        start_date, term_type = privacy.split(" ")
        end_date = calc_date(start_date, term_dict[term_type])
        print(end_date)
        if compare_date(today, end_date) > 0:
            answer.append(i+1)
        
        
    return answer
# 2022.05.19 > 2021.11.01 -> 1
def compare_date(today, end_date):
    t_year, t_month, t_date = map(int, today.split("."))
    e_year, e_month, e_date = map(int, end_date.split("."))
    if t_year == e_year:
        if t_month == e_month:
            if t_date > e_date:
                return 1
            else:
                return -1
        elif t_month > e_month:
            return 1
        else:
            return -1
    elif t_year > e_year:
        return 1
    else:
        return -1
    
    return -1
    
# exp: 유효기간(달)
# 2021.05.02 => 2021.11.01
def calc_date(start_date, exp):
    year, month, day = map(int, start_date.split("."))
    month += exp

    if month > 12:
        if month % 12 == 0:
            year += (month - 1) // 12
        else: 
            year += month // 12
        month = month % 12
        
        if month == 0:
            month = 12
        
    day -= 1
    if day < 1:
        month -= 1
        if month < 1:
            year -= 1
            month = 12
        day = 28
    
    result = str(year) + "." + ("0"+str(month) if month < 10 else str(month)) + "." +("0"+str(day) if day < 10 else str(day))
    
    return result
            
    
    
    
    