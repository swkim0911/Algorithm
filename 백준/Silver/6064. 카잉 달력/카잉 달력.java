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
            int x = Integer.parseInt(split[2]) - 1;
            int y = Integer.parseInt(split[3]) - 1;
            boolean isOk = false;

            for (int i = x; i < (n * m); i+= m) {
                if(i % n == y){
                    sb.append(i + 1).append("\n");
                    isOk = true;
                    break;
                }
            }

            if(!isOk) sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }
}