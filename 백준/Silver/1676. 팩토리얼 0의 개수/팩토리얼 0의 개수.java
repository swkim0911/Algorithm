import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(n >= 5){
            cnt += n / 5; // 곱해지는 5의 개수 만큼 0이 존재한다.
            n /= 5;
        }
        System.out.println(cnt);
    }
}