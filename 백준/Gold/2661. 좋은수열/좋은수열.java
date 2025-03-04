import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n, "");
        System.out.println(answer);
    }

    public static void dfs(int n, String str) {
        if(answer != null) return;
        if (str.length() == n) {
            answer = str;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(check(str, i)) dfs(n, str + i);
        }
    }

    public static boolean check(String str, int nxt) {
        int len = str.length() + 1;
        str += nxt;
        for (int i = 1; i <= len/ 2; i++) { // i: 칸 수
            String back = str.substring(len - i);
            String front = str.substring(len - (2 * i), len - i);
            if(back.equals(front)) return false;
        }
        return true;
    }
}