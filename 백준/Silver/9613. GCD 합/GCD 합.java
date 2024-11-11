import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 0;
            for(int i = 0; i < n-1; i++){
                for (int j = i + 1; j < n; j++) {
                    int a = arr[i];
                    int b = arr[j];
                    answer += gcd(a,b);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }


    public static int gcd(int a,int b){
        int r;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
