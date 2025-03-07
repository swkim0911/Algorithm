import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = first;
        int answer = -1;
        String ansList = "";
        while(second >= (first / 2)){
            int bbefore = first;
            int before = second;
            int cur = bbefore - before;
            StringBuilder sb = new StringBuilder(bbefore + " " + before);
            int cnt = 2;
            while(cur >= 0){
                cnt++;
                sb.append(" " + cur);
                bbefore = before;
                before = cur;
                cur = bbefore - before;
            }
            if (answer < cnt) {
                answer = cnt;
                ansList = sb.toString();
            }
            second--;
        }
        System.out.println(answer);
        System.out.println(ansList);
    }
}
