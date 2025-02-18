import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        int[] cnt = new int[100_001];
        while (right < arr.length) {
            while (right < arr.length && cnt[arr[right]] < k) {
                cnt[arr[right]]++;
                right++;
            }
            int len = right - left;
            ans = Math.max(ans, len);
            cnt[arr[left]]--;
            left++;
        }

        System.out.println(ans);
    }
}