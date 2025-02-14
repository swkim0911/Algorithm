import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int left = 1;
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int total = getTotal(arr, mid);
            if(total > m){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        System.out.println(right);
    }

    public static int getTotal(int[] arr, int mid) {
        int sum = 0;
        for (int v : arr) {
            sum += Math.min(mid, v);
        }
        return sum;
    }
}