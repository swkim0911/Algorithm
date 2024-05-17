import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int SIZE = 9;

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int n = (Integer.parseInt(br.readLine()));
            int[][] arr = new int[n][n];
            arr[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(j == 0 || j == n - 1){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    }
                }
            }
            sb.append("#").append(t).append(" ").append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
