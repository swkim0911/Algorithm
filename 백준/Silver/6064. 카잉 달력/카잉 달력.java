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
            boolean check = false;
            int lcm = (m * n) / gcd(m, n);
            for(int i = x; i <= lcm; i += m){
                int r = i % n;
                if(r == 0){
                    r = n;
                }
                if(r == y){
                    sb.append(i).append("\n");
                    check = true;
                    break;
                }

            }
            if(!check) sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }
    
    // 최대공약수
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