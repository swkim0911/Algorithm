import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[][] dp = new int[k+1][n+1]; // dp[x][y]: 정수 x개 더해서 합이 y가 되는 경우의 수
        // 초기화
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i-1][l];
                    dp[i][j] %= 1_000_000_000;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}

