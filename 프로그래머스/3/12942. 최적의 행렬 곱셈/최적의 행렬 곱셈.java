import java.util.*;

class Solution {
    
    public static final int INF = Integer.MAX_VALUE;
    
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n]; // dp[x][y]: x번째 행렬부터 y번 행렬까지에서 최소 연산 수
        for(int[] row : dp){
            Arrays.fill(row, INF);
        }
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }
        for(int g = 1; g < n; g++){ // gap
            for(int s = 0; s < n; s++){ // 시작 배열 idx
                int e = s+g; // 끝 배열 idx
                if(e >= n) break;
                
                for(int m = s; m < e; m++){
                    dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m+1][e] + (matrix_sizes[s][0] * matrix_sizes[m+1][0] * matrix_sizes[e][1]));
                }
            }
        }
        return dp[0][n-1];
    }
}