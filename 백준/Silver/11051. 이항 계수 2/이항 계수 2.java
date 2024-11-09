import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[][] dp = new int[n + 1][n + 1]; // dp[x][y]: xCy

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10_007;
            }
        }
        System.out.println(dp[n][k]);
    }
}