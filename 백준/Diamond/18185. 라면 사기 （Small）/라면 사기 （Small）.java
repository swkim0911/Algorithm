import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int ans = 0;
        while(idx < n){
            if(arr[idx] > 0){
                int tmp = arr[idx];
                ans += 3 * tmp;
                tmp = Math.min(tmp, arr[idx + 1]);
                ans += 2 * tmp;
                arr[idx+1] -= tmp;
                tmp = Math.min(tmp, arr[idx+2] - Math.min(arr[idx + 1], arr[idx + 2]));
                ans += 2 * tmp;
                arr[idx + 2] -= tmp;
            }
            idx++;
        }
        System.out.println(ans);
    }
}