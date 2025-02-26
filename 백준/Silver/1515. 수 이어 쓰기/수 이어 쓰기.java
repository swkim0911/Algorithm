import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        String num = "1";
        int i = 0;
        while (i < number.length()) {
            int cnt = 0; // 겹친 문자 개수
            int lIdx = 0;
            int rIdx = i;
            while (lIdx < num.length()) {
                if(rIdx < number.length() && num.charAt(lIdx) == number.charAt(rIdx)) {
                    rIdx++;
                    cnt++;
                }
                lIdx++;
            }
            i += cnt;
            num = String.valueOf(Integer.parseInt(num) + 1);
        }
        System.out.println(Integer.parseInt(num) - 1);
    }
}