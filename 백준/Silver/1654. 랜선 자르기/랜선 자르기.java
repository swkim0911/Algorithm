import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int k = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[] arr = new int[k];
        long left = 1;
        long right = -1;  // 가능한 랜선의 범위
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }
        while(left < right){
            long mid = (left + right) / 2 + 1; // [g, g, g, g, b, b, b, b, b, b]  + 1 을 하는 이유는
            // 구간이 5개/5개로 나눠진게 아니라 4개/6개로 나눠졌습니다. 이건 적절한 mid 값을 택하지 못해서 발생하는 문제인거고, 단지 정확히 절반으로 나누지 않기 때문에 다소 비효율적이라는 것에서 끝나는게 아니라 아예 일부 값에 대해서 아예 무한 루프에 빠질 수 있습니다.
            long cnt = 0;
            for(int i = 0; i < k; i++){
                cnt += arr[i] / mid;
            }
            if(cnt < n){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        System.out.println(left);
    }
}