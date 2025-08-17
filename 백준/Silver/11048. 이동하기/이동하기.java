import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][m+1]; // dp[x][y]: (1,1)에서 (x,y)까지 가져올 수 있는 최대 사탕 개수
        dp[1][1] = board[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i + 1 <= n){
                    dp[i+1][j] = Math.max(dp[i][j] + board[i+1][j], dp[i+1][j]);
                }
                if(j + 1 <= m){
                    dp[i][j+1] = Math.max(dp[i][j] + board[i][j + 1], dp[i][j + 1]);
                }
                if (i + 1 <= n && j + 1 <= m) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + board[i + 1][j + 1], dp[i + 1][j + 1]);
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
