import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n+1];
        int[][] dp = new int[n+1][k+1]; // dp[x][y]: x번째 코인까지 쓰고 가치의 합을 y로 만들 수 있는 경우의 수
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) { // 가치 합
                dp[i][j] = dp[i-1][j]; //
                if(coin[i] <= j){ //
                    if(coin[i] == j){
                        dp[i][j] = dp[i-1][j] + 1;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i]];
                    }
                }
            }
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                sb.append(dp[i][j] + " ");
//            }
//            sb.append("\n");
//        }
//        System.out.print(sb);
        System.out.print(dp[n][k]);
        /**
         *    1  2  3  4  5  6  7  8  9  10
         * 1  1  1  1  1  1  1  1  1  1  1
         * 2  1  2  2
         * 3
         */
    }
}
