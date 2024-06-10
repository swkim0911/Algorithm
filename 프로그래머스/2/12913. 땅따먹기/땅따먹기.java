class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4]; // dp[k][j] = k번째 행에서 j 열을 밟았을 때 최댓값
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i]; // 초기화
        }
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));  
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));  
            dp[i][2] = land[i][2] + Math.max(dp[i-1][1], Math.max(dp[i-1][0], dp[i-1][3]));  
            dp[i][3] = land[i][3] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][0]));  
        }
        int answer = 0;
        for(int i = 0; i < 4; i++){
            if(answer < dp[dp.length-1][i]) answer = dp[dp.length-1][i];
        }
        return answer;
    }
}

//dp