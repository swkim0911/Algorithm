import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()) {
            char c = t.charAt(t.length() - 1);
            if(c == 'A'){
                t = t.substring(0, t.length() - 1);
            }else if(c == 'B'){
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            }
        }
        int answer = s.equals(t) ? 1 : 0;
        System.out.println(answer);
    }
    // 브루트 포스: 2^999
    // t에서 거꾸로 s를 찾아가면 시간 복잡도 O(t.length)
}
