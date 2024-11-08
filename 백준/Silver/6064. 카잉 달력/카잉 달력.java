import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] split = br.readLine().split(" ");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            int x = Integer.parseInt(split[2]);
            int y = Integer.parseInt(split[3]);
            boolean isOk = false;
            for (int i = x; i <= lcm(m, n); i += m) {
                int b = i % n;
                if (b == 0) b = n;  // Adjust for 0 case

                if (b == y) {
                    sb.append(i).append("\n");
                    isOk = true;
                    break;
                }
            }
            if(!isOk) sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }

    public static int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }

    public static int gcd(int a, int b){
        int r = 0;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
/**
 * 10 12
 * 1 -> <1,1> <60,60> 나누어 떨어지면 그대로
 * 11 -> (1,11)
 * 13 -> (3,1)
 * 60 -> (10,12)
 *
 * 1. 최대: 최소공배수
 * 2. x % 10 = 3, x % 12 = 1
 * 3. 1 부터 최대까지
 */

