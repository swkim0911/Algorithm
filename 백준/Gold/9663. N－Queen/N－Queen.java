import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int cnt;
    static boolean[] visited1; // 체스판의 열에 퀸이 있는지 확인
    static boolean[] visited2; // 체스판의 \ 에 퀸이 있는지 확인 (x - y 가 같은지 확인)
    static boolean[] visited3; // 체스판의 / 에 퀸이 있는지 확인 (x + y 가 같은지 확인)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited1 = new boolean[30];
        visited2 = new boolean[30];
        visited3 = new boolean[30];

        func(0);
        System.out.println(cnt);
    }

    public static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int y = 1; y <= n; y++) { // 체스판의 index를 1부터 시작하는 걸로 가정
            int x = cur + 1;
            if(visited1[y] || visited2[x - y + n] || visited3[x + y]) continue;
            visited1[y] = true;
            visited2[x - y + n] = true;
            visited3[x + y] = true;
            func(cur + 1);
            visited1[y] = false;
            visited2[x - y + n] = false;
            visited3[x + y] = false;
        }
    }
}
