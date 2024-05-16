
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int count = 1;
            int x = 0, y = 0;
            int dir = 0;
            while(count <= n*n){
                arr[x][y] = count++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0){
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
