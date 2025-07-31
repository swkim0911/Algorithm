import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<Integer>[] positions = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                positions[i] = new ArrayList<>();
            }

            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                positions[c - 'a'].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for (int i = 0; i < 26; i++) {
                List<Integer> position = positions[i]; // i + 'a' 문자의 위치 list
                if(position.size() < k) continue;

                for (int j = 0; j <= position.size() - k; j++) {
                    int len = position.get(j + k - 1) - position.get(j) + 1;
                    minLen = Math.min(len, minLen);
                    maxLen = Math.max(len, maxLen);
                }
            }

            if (maxLen == -1) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }

        }
    }
}




