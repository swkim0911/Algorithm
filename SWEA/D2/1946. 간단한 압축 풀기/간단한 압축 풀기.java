import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            sb.append("#").append(t).append("\n");
            int n = Integer.parseInt(br.readLine());
            int head = 0; // head 0~9
            for (int i = 0; i < n; i++) {
                String[] split = br.readLine().split(" ");
                String c = split[0];
                int k = Integer.parseInt(split[1]);
                for (int j = 0; j < k; j++) { // 9 10 11
                    if(head == 10) {
                        sb.append("\n");
                        head = 0;
                    }
                    sb.append(c);
                    head++;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
