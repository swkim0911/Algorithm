import java.util.*;

class Solution {
    
    public static final int INF = Integer.MAX_VALUE;
    
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n]; // dp[x][y]: x번째 행렬에서 y번째 행렬까지 최소 곱셈 연산 수 (0 <= x,y <= n-1)
        for(int[] row : dp){
            Arrays.fill(row, INF);
        }
        
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }
        
        for(int i = 1; i < n; i++){
            for(int s = 0; s < n; s++){
                int e = s + i;
                if(e >= n) break;
                
                for(int m = s; m < e; m++){
                    dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m+1][e] + (matrix_sizes[s][0] * matrix_sizes[m+1][0] * matrix_sizes[e][1]));
                }
            }
        }
        
        return dp[0][n-1];
    }
}

// 5 3 10 + 5 10 6 = 450
// 5 3 6 + 3 10 6 = 270