import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int bundle = Integer.parseInt(br.readLine());
            pq.add(bundle);
        }
        long ans = 0;
        while (pq.size() > 1) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                int min = pq.poll();
                sum += min;
            }
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
        
        /**
         * a + b
         * a + b + c
         * a + b + c + d
         * = 3a + 3b + 2c + d
         */

        /**
         * a + b
         * c + d
         * a + b + c + d
         * = 2a + 2b + 2c + 2d
         */
    }
}
