import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int k = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[] arr = new int[k];
        long left = 1; // 가능한 랜선의 범위
        long right = 0x7fffffff;
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 1 - 457
        while(left < right){
            long mid = (left + right) / 2 + 1; // target 길이
            long cnt = 0;
            for(int i = 0; i < k; i++){
                cnt += arr[i] / mid;
            }
            if(cnt < n){
                right = mid - 1;
            }else if(cnt == n){
                left = mid;
            }else if(cnt > n){
                left = mid;
            }
        }
        System.out.println(left);
    }
}

// n = 11;
// 802, 743, 457, 539
// n개를 만들 수 있는 랜선의 최대 길이. -> n이 11에 가까워야 함.
