import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr); // 오른차순 정렬
        long answer = -1;
        if(n % 2 == 0){
            for (int i = 0; i < n / 2; i++) {
                answer = Math.max(arr[i] + arr[n - 1 - i], answer);
            }
        }else{
            // 1 2 3 4 5 6
            answer = arr[n - 1];
            for (int i = 0; i < n / 2; i++) {
                answer = Math.max(arr[i] + arr[n - 2 - i], answer);
            }

        }
        System.out.println(answer);
    }

}