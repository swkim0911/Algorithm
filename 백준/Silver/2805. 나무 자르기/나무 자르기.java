import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            long total = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] >= mid){
                    total += (arr[i] - mid);
                }
            }
            if(total >= m){
                left = mid + 1;
                answer = mid;

            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
        // 절단기에 설정할 수 있는 높이의 최댓값
    }
}

