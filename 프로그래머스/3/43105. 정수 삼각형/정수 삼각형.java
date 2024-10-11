class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n+1][n+1]; // dp[x][y]: 시작에서 삼각형의 x 높이(꼭대기에서 현위치)에 y번째 위치까지 갔을 때의 최댓값
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i-1][j-1];
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int val : dp[n]){
            answer = Math.max(answer, val);
        }
        return answer;
    }
}