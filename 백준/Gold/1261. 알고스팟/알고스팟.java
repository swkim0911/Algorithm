import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    static int m;
    static int n;
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        board = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i+1][j+1] = line.charAt(j) - '0';
            }
        }
        int answer = bfs(1, 1);
        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        boolean[][] visited = new boolean[n + 1][m + 1];
        pq.add(new Point(x, y, 0));
        visited[x][y] = true;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if(cur.x == n && cur.y == m){
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if((nx < 1 || nx > n || ny < 1 || ny > m) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                pq.add(new Point(nx, ny, board[nx][ny] == 0 ? cur.cnt : cur.cnt + 1));
            }

        }
        return -1;
    }
}

class Point{
    int x;
    int y;
    int cnt;

    public Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

