import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬

        long minVal = Long.MAX_VALUE;
        int[] ans = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = (long)arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < Math.abs(minVal)) {
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                    minVal = sum;
                }
                if (sum < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
