class Solution {
    public int solution(int[] money) {
       int[][] dp = new int[2][money.length]; // dp[0][x]: 첫집 방문o. x까지 최댓값, dp[1][x]: 첫집 방문x. x까지 최댓값
        dp[0][0] = money[0];
        dp[1][0] = 0;
        
        dp[0][1] = money[0];
        dp[1][1] = money[1];
        
        for(int i = 2; i < money.length; i++){
            dp[0][i] = Math.max(dp[0][i-1], money[i] + dp[0][i-2]); 
            dp[1][i] = Math.max(dp[1][i-1], money[i] + dp[1][i-2]);
        }
        
        return Math.max(dp[1][money.length-1], dp[0][money.length-2]); // dp[0][money.length-2]: 첫집 방문한 경우 money.length-1을 방문할 수 없다.
    }
}