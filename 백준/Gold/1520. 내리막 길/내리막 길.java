import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int m,n;
    static int[][] board, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[m + 1][n + 1]; // dp[x][y]: 위치(x,y) 에서 끝점(m,n) 까지 가는 경로의 수
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        int answer = dfs(1, 1);
        System.out.println(answer);
    }

    public static int dfs(int x, int y) {
        if(x == m && y == n){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 1 || nx > m || ny < 1 || ny > n) continue;
            if(board[nx][ny] < board[x][y]){
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}

