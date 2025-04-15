import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int num = 666;
        int t = 0;
        while(true){
            if(String.valueOf(num).contains("666")){
                t++;
            }
            if(t == n) break;
            num += 1;
        }
        System.out.println(num);
    }
}

// 666, 1666, 2666, 3666,4666, 5666, 6660, 6666, 7666, 8666, 9666, 10666