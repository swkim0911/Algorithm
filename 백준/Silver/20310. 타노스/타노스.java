import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroCnt += 1;
            }else{
                oneCnt += 1;
            }
        }
        int zeroHalf = zeroCnt / 2;
        int oneHalf = oneCnt / 2;
        for (int i = 0; i < s.length(); i++) {
            if(oneHalf == 0) break;
            char c = s.charAt(i);
            if (c == '1') {
                s = s.substring(0, i) + s.substring(i + 1);
                oneHalf -= 1;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if(zeroHalf == 0) break;
            char c = s.charAt(i);
            if (c == '0') {
                s = s.substring(0, i) + s.substring(i + 1);
                zeroHalf -= 1;
            }
        }
        System.out.println(s);
    }
    // 1은 앞에있는 1을 없애고, 0은 뒤에 있는 0을 없애자

}
