import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 123_456 * 2 + 1;
        boolean[] notPrime = new boolean[size];
        for (int i = 2; i < notPrime.length; i++) {
            if(notPrime[i]) continue;
            int cur = i;
            int m = 2;
            while(cur*m <= notPrime.length){
                notPrime[cur*m] = true;
                m++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int cnt = 0;
            for(int i = n+1; i <= 2*n; i++) {
                if (!notPrime[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}