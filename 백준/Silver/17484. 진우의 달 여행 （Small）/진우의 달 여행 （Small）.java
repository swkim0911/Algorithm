import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int answer = Integer.MAX_VALUE;
    public static int[][] dir = {
            {1, -1}, {1, 0}, {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < m; j++) {
            dfs(board, n, m, new Point(0, j), -1, 0);
        }
        System.out.println(answer);
    }

    public static void dfs(int[][] board, int n, int m, Point cur, int prev, int sum) {
        if (cur.x == n - 1) { // 마지막 행 도착
            answer = Math.min(answer, sum + board[cur.x][cur.y]);
            return;
        }

        for (int d = 0; d < 3; d++) {
            if(prev == d) continue;
            int nx = cur.x + dir[d][0];
            int ny = cur.y + dir[d][1];
            if(nx < 0  || ny < 0 || ny >= m || nx >= n) continue; // 경계 밖
            dfs(board, n, m, new Point(nx, ny), d, sum + board[cur.x][cur.y]);
        }
    }

    public static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
