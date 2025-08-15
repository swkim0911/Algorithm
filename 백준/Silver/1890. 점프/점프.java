import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n]; // dp[x][y]: (x,y)에서 (n-1,n-1)로 갈 수 있는 경우의 수
        dp[n-1][n-1] = 1L;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(i == n-1 && j == n-1) continue;
                for (int d = 0; d < 2; d++) {
                    int nx = i + board[i][j] * dx[d];
                    int ny = j + board[i][j] * dy[d];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    dp[i][j] += dp[nx][ny];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    // 반드시 오른쪽이나 아래로



}
