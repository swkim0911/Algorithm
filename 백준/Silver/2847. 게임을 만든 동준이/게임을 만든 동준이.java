import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if(arr[i] >= arr[i+1]){
                int tmp = arr[i];
                arr[i] = arr[i+1] - 1;
                ans += tmp - arr[i];
            }
        }
        System.out.println(ans);
    }
}