import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double[] dp = new double[n]; // dp[i]: arr[i] 까지 수 중에 최댓값
        dp[0] = arr[0];
        double answer = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                dp[i] = arr[i];
            }else{
                dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.printf("%.3f", answer);
    }
    // 소수점 4자리에서 반올림
    public static float round(double number) {
        return Math.round(number*1000) / (float)1000;
    }
}