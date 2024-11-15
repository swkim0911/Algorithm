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
        int size = 10_001;
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[4][size]; // dp[1][x]: 1만 써서 x를 만든 경우의 수. dp[2][x]: 1,2 써서 x를 만든 경우의 수
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        for (int i = 1; i <= 3; i++) {
            for(int j = 1; j < size; j++){
                if(j < i){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-i];
                }
            }
        }
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[3][n]).append("\n");
        }
        System.out.print(sb);
    }
}