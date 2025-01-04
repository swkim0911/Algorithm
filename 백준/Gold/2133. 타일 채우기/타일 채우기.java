import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31]; // dp[x]: 3 * x 크기 타일의 경우의 수
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= 30; i += 2) {
            dp[i] = dp[i-2] * dp[2];
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}