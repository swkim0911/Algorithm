
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testcase; t++){
            int ans = Integer.MIN_VALUE;
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i <= n - m; i ++) {
                for (int j = 0; j <= n - m; j++) {
                    int tmp = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            tmp += board[i + k][j + l];
                        }
                    }
                    ans = Math.max(tmp, ans);

                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
