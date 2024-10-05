import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        int[][] dp = new int[n+1][k+1]; // dp[x][y]: 1번, 2번, .. x번 물건까지 사용해서 k무게 까지 채웠을 때 최대 가치
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
        }
        for(int i = 1; i <= n; i++){
            for(int j =1; j <= k; j++){
                dp[i][j] = dp[i-1][j];
                if(j - arr[i][0] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
    // {6,13}, {4,8}, {3,6}, {5,12}
    // 1    2   3   4   5   6   7
    // 0    0   0   0   0   13  13
    // 0    0   0   8   0   13  13
    // 0    0   6   8   0   13  14
    // 0    0   6   8   12  13  14
}

