import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            String cur = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for (int j = 0; j < first.length(); j++) {
                char c = first.charAt(j);
                word[c - 'A'] += 1;
            }
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                if(word[c - 'A'] > 0){
                    cnt += 1;
                    word[c - 'A'] -= 1;
                }
            }
            if (first.length() == cur.length() && (cnt == first.length() || cnt == first.length() - 1)) { // 같은 구성이거나 문자 한개만 바꾸면 되는 유사한 문자이거나
                answer += 1;
            } else if (first.length() + 1 == cur.length() && cnt == first.length()) {
                answer += 1;
            } else if (first.length() == cur.length() + 1 && cnt == cur.length()) {
                answer += 1;
            }
        }


        System.out.println(answer);
    }

}
