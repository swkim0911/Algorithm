import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<Integer>[] list = new ArrayList[26]; // list[x] : x + 'a' 알파벳의 위치 index를 포함하는 ArrayList
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }


            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                list[c - 'a'].add(i);
            }

            int minLen = w.length() + 1;
            int maxLen = -1;

            for (int i = 0; i < 26; i++) {
                List<Integer> positions = list[i]; // positions: i + 'a' 알파벳의 위치 인데스 리스트
                if(positions.size() < k) continue; // 총 개수가 k를 넘지 못하면 조건을 충족시키지 못한다.
                for (int j = 0; j <= positions.size() - k; j++) {
                    int len = positions.get(j + k - 1) - positions.get(j) + 1;
                    minLen = Math.min(len, minLen);
                    maxLen = Math.max(len, maxLen);
                }
            }

            if (maxLen == -1) {
                System.out.println(-1);
            }else{
                System.out.println(minLen+" "+maxLen);
            }
        }
    }
}
