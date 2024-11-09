import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int answer = 1;
        for(int i = n; i > n-k; i--){
            answer *= i;
        }
        for(int i = 1; i <= k; i++){
            answer /= i;
        }
        System.out.println(answer);
    }
}