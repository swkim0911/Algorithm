import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬
        int left = 0;
        int right = n - 1;
        int[] ans = new int[2];
        int val = Integer.MAX_VALUE;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < Math.abs(val)){
                val = sum;
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            if(sum < 0){
                left += 1;
            }else if (sum > 0){
                right -= 1;
            }else {
                break;
            }
        }
        System.out.println(ans[0] + " "+ans[1]);
        // -99, -2, -1, 4, 98 // -1,
    }
}
