class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            // 약수 개수
            int cnt = 0;
            
            for(int j = 1; j <= (int)Math.sqrt((double)i); j++){
                if (i % j == 0) {
                    cnt++; 
                    if (j != i / j) {
                        cnt++;  // n / i is also a divisor
                    }
                }
            }
            if(cnt > limit) answer += power;
            else answer += cnt;
        }
        return answer;
    }
}

