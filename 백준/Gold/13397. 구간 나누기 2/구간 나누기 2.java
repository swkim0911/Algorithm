import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static final int INF = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        int left = 0;
        int right = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }

        while(left < right) {
            int mid = (left + right) / 2;
            if (func(n, arr, mid) <= m) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);

    }

    public static int func(int n, int[] arr, int mid){
        int count = 1;
        int min = INF;
        int max = -INF;
        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid){
                count++;
                max = -INF;
                min = INF;
                i--;
            }
        }

        return count;
    }
}

