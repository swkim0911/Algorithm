import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int totalACnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a') totalACnt += 1;
        }
        int answer = Integer.MAX_VALUE;
        char[] charArray = (str + str).toCharArray();
        for (int s = 0; s < str.length(); s++) {
            int ACnt = 0;
            for (int i = s; i < s + totalACnt; i++) {
                if(charArray[i] == 'a'){
                    ACnt += 1;
                }
            }
            answer = Math.min(answer, totalACnt - ACnt);
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
