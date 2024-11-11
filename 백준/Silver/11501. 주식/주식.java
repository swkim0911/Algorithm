import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            long answer = 0L;

            for (int i = n - 1; i >= 0; i--) {
                if(arr[i] > max){
                    max = arr[i];
                }else{
                    answer += max - arr[i];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}