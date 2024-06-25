class Solution {
    int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
    String[] dates = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    
    public String solution(int a, int b) {
        int day = 0;
        for(int i = 0; i < a - 1; i++){
            day += days[i];
        }
        day += b - 1;
        int date = day % 7;
        
        return dates[date];
    }
}

// 1 금 2 토 3 일 4 월 5 화 6 수 7 목 8 금
// 1월 1일 금 (0)
// 1월 2일 토 (1)
// 1월 31일 x (30) -> 7*4 + 2 일
// 2월 1일 x (31) -> 7*4 + 3 월 0,1,2,3,4,5,6,7
// 5월 24일 x ()
//31