import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[2_000_001];
        dp[1_000_000] = 0;
        dp[1_000_001] = 1;
        for (int i = 1_000_002; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1_000_000_000;
        }

        for (int i = 999_999; i >= 0; i--) {
            dp[i] = dp[i + 2] - dp[i+1];
            dp[i] %= 1_000_000_000;
        }
        int sig = Integer.signum(dp[1_000_000 + n]);
        int val = Math.abs(dp[1_000_000 + n]);
        System.out.println(sig);
        System.out.println(val);
    }

}
