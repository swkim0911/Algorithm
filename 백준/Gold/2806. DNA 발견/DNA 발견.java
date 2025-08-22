import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[][] dp = new int[n][2]; //dp[x][0]: 모두 a로 만드는 최소 돌연변이 횟수 dp[x][1]: 모두 b로 만드는 최소 돌연변이 횟수
        // 초기화
        if(str.charAt(0) == 'A'){
            dp[0][0] = 0;
            dp[0][1] = 1;
        }else{
            dp[0][0] = 1;
            dp[0][1] = 0;
        }
        for (int i = 1; i < n; i++) {
            char c = str.charAt(i);
            if(c == 'A'){
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1] + 1);
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            }else{
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
                dp[i][1] = Math.min(dp[i-1][0] + 1, dp[i-1][1]);
            }
        }
        int answer = Math.min(dp[n-1][0], dp[n-1][1] + 1);
        System.out.println(answer);


    }
}