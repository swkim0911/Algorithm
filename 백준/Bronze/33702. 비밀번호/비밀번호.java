import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        // 1 -> [0][0], 2 -> [0][1], 3 -> [0][2]
        // 2 -> [1][0]
        int[] pos = kToPos(k);
        boolean[][] visited = new boolean[3][3];
        visited[pos[0]][pos[1]] = true;
        dfs(pos[0], pos[1], 0, visited);
        System.out.println(answer);
    }

    static int[] kToPos(int k) {
        int x = (k - 1) / 3;
        int y = (k - 1) % 3;
        return new int[]{x, y};
    }

    static void dfs(int x, int y, int depth, boolean[][] visited) {
        if(depth == 8){
            answer += 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue; // 범위 밖
            if(visited[nx][ny])continue;
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, visited);
            visited[nx][ny] = false;
        }
    }
}
