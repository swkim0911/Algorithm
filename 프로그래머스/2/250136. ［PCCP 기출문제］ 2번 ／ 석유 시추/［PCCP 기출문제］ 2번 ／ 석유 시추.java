import java.util.*;

class Solution {

    int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int[] oils; // oils[i]: i+1 열에 시추관을 설치했을 때 얻을 수 있는 석유량

    boolean[][] visited;
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oils = new int[m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j, land);
            }
        }

        return Arrays.stream(oils).max().getAsInt();
    }
    public void bfs(int x, int y, int[][] land) {
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>(); // 한 덩어리의 석유가 위치하는 열(y)들의 집합
        q.add(new Pair(x, y));
        visited[x][y] = true;
        int sum = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            set.add(cur.y); // 현재 땅의 열(y) 위치를 set에 저장
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(land[nx][ny] == 0 || visited[nx][ny]) continue;
                sum++;
                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }
        for (Integer col : set) {
            oils[col] += sum;
        }
    }

}

 class Pair{
    int x, y;

     public Pair(int x, int y) {
         this.x = x;
         this.y = y;
     }
 }