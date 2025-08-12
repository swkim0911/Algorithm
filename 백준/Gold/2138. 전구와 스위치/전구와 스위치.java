import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] start = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int result1 = simulate(n, start, target, false);
        int result2 = simulate(n, start, target, true);
        int answer = Math.min(result1, result2);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }

    static int simulate(int n, char[] start, char[] target, boolean firstPress){
        char[] cur = start.clone();
        int cnt = 0;
        if (firstPress) {
            press(cur, 0);
            cnt +=1;
        }
        for (int p = 1; p < n; p++) {
            if (cur[p - 1] != target[p - 1]) {
                press(cur, p);
                cnt += 1;
            }
        }
        cnt = cur[n - 1] != target[n - 1] ? Integer.MAX_VALUE : cnt;
        return cnt;
    }

    static void press(char[] arr, int p) {
        int n = arr.length;

        for (int i = p - 1; i <= p + 1; i++) {
            if (0 <= i && i < n) {
                arr[i] = (arr[i] == '0' ? '1' : '0');
            }
        }

    }
}