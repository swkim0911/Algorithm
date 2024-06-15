import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int[] dp = new int[100_001];
        dp[0] = 1;
        for(int m : money){
            for(int j = m; j <= n; j++){
                dp[j] += dp[j-m];
            }
        }
        
        return dp[n];
    }
    // dp[i]: money로 i를 만들 수 있는 경우의 수
    
}

