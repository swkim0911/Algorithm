import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001]; // dp[x]: 돌 x개 있을 때 이기는 사람(1: 상근, 2: 창영)
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;
        for(int i = 5; i <= 1000; i++){
            if(dp[i-1] % 2 == 0 || dp[i-3] % 2 == 0 || dp[i-4] % 2 == 0) dp[i] = 1;
            else dp[i] = 2;
        }
        String answer = dp[n] == 1 ? "SK" : "CY";
        System.out.println(answer);
    }
}

