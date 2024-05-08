import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    static StringBuilder sb = new StringBuilder();
    static String[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1}; // 좌,우,하
    static int[] dy = {-1,1, 0};

    static final int LENGTH = 100;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 10;
        while(testcase-- > 0) {
            int t = Integer.parseInt(br.readLine());
            board = new String[LENGTH][LENGTH];
            for (int i = 0; i < LENGTH; i++) {
                board[i] = br.readLine().split(" ");
            }

            for (int i = 0; i < board.length; i++) {
                if (board[0][i].equals("1")) {
                    visited = new boolean[LENGTH][LENGTH];
                    int ans = bfs(0, i);
                    if(ans != -1){
                        sb.append("#").append(t).append(" ").append(ans).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        int ans = -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if(cur.x == board.length - 1 && board[cur.x][cur.y].equals("2")){
                ans = y;
                break;
            }
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                if(visited[nx][ny] || board[nx][ny].equals("0")) continue;
                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
                break;
            }
        }
        return ans;
    }
}

class Pair{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}