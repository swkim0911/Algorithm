import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 3;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int total = 0;
            int[][] coins = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());
                total += coins[i][0] * coins[i][1];
            }

            if((total & 1) == 1){ // total이 홀수인 경우
                sb.append(0).append("\n");
                continue;
            }
            int half = total / 2;
            boolean[] dp = new boolean[half + 1]; // dp[x]: x를 만들 수 있는지 여부
            dp[0] = true;
            // 3 - 2, half = 3
            for (int i = 0; i < n; i++) {
                int value = coins[i][0];
                int quantity = coins[i][1];

                for (int j = half; j >= 0; j--) {
                    if(!dp[j]) continue;
                    for (int k = 1; k <= quantity; k++) {
                        int nj = j + value * k;
                        if(nj <= half){
                            dp[nj] = true;
                        }
                    }
                }
            }
            sb.append(dp[half] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
