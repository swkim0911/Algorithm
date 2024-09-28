import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n]; // dp[i]: i번째 수열까지 가장 긴 감소하는 부분 수열의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        // 10 30 10 20 20 10
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}