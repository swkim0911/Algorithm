import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            int  cur = dp[i][j];
            if(dp[i-1][j] == dp[i][j]){
                i -= 1;
            }else if(dp[i][j-1] == dp[i][j]){
                j -= 1;
            }else{
                sb.insert(0, str1.charAt(i-1));
                i--;
                j--;
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
        System.out.print(sb);
    }
}