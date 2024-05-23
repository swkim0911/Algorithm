import java.util.*;

class Solution {
    int n, m;
    int[] oil;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        oil = new int[m];

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j);
                }
            }
        }
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }

    public void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visited[x][y] = true;
        int count = 1;
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            set.add(cur.y);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new Pair(nx,ny));
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }

        for (int index : set) {
            oil[index] += count;
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