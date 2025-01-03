import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][k+1]; // dp[x][y]: x번째 수까지 썼을 때, y를 만드는 경우의 수
        for (int i = 1; i <= k; i++) {
            dp[0][i] = INF;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j-arr[i-1] >= 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-arr[i-1]] + 1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[i][k]);
        }
        if(answer == INF){
            answer = -1;
        }
        System.out.print(answer);
    }
}