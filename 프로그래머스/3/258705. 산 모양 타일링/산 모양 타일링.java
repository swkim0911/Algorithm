class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[][] dp = new int[n+1][2]; 
        // dp[x][0]: 오른쪽 끝에 까지 포함한 경우의 수
        // dp[x][1]: 오른쪽 끝 포함하지 않은 경우의 수
        
        // 초기화
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 1; i <= n; i++){
            int top = tops[i-1];
            if(top == 0){
                dp[i][0] = ((dp[i-1][0] * 2) + (dp[i-1][1] * 1)) % 10_007;
                dp[i][1] = ((dp[i-1][0] * 1) + (dp[i-1][1] * 1)) % 10_007;
            }else if(top == 1){
                dp[i][0] = ((dp[i-1][0] * 3) + (dp[i-1][1] * 1)) % 10_007;
                dp[i][1] = ((dp[i-1][0] * 2) + (dp[i-1][1] * 1)) % 10_007;
            }
        }
        
        return dp[n][0];
    }
}