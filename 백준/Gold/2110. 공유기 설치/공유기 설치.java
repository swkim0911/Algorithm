import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1];
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int i = 0;
            int cur = arr[i];
            int cnt = 1; // 설치된 공유기 개수
            while(i < n){
                if(arr[i] - cur >= mid){
                    cur = arr[i];
                    cnt++;
                }
                i++;
            }
            if(cnt < c){
                right = mid - 1;
            }else{
                left = mid + 1;
                ans = mid;
            }
        }
        System.out.println(left - 1);
    }
}