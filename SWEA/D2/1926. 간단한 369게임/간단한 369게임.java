
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            int cnt = 0;
            s = s.replace("3", "-");
            s = s.replace("6", "-");
            s = s.replace("9", "-");
            if (s.contains("-")) {
                s = s.replaceAll("[0-9]", "");
            }
            sb.append(s).append(" ");
        }
//        sb.append("#").append(t).append(" ").append(ans).append("\n");

        System.out.println(sb);
    }
}
