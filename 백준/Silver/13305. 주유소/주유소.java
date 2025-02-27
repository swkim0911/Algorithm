import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        int[] fuels = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fuels[i] = Integer.parseInt(st.nextToken());
        }
        int fuel = fuels[0];
        long answer = 0L;
        for (int i = 1; i < n; i++) {
            answer += fuel * (long) dist[i - 1];
            fuel = Math.min(fuel, fuels[i]);
        }
        System.out.println(answer);
    }
    // 목표지점까지 최소 비용으로 가기
}