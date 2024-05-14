
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testcase; t++){
            long ans = 0;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = 0;
            for(int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if(i != 0){
                    arr[i] = cur - before;
                }
                before = cur;
            }
            long tmp = 0;
            for (int i = n - 1; i >= 1; i--) {
                tmp += arr[i];
                if(tmp >= 0){
                    ans += tmp;
                }else{
                    tmp = 0;
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
