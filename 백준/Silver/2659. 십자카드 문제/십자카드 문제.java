import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.MAX_VALUE;
        for (int s = 0; s < 4; s++) {
            int v = getValueWithStartIndex(s, arr);
            target = Math.min(target, v);
        }
        dfs(target, "");
        System.out.println(answer);
    }

    public static void dfs(int target, String cur) {
        if(answer != 0) return;
        if (cur.length() == 4) {
            if(isMin(cur)){
                cnt++;
                if(target == Integer.parseInt(cur)){
                    answer = cnt;
                }
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            dfs(target, cur + i);
        }
    }

    public static boolean isMin(String cur) {
        int curVal = Integer.parseInt(cur);
        Integer[] array = Arrays.stream(cur.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 1; i < 4; i++) {
            int v = getValueWithStartIndex(i, array);
            if(v < curVal) return false;
        }
        return true;
    }

    private static int getValueWithStartIndex(int s, Integer[] arr) {
        int v = 0;
        int t = 0;
        for (int i = s; i < s + 4; i++) {
            int j = i % 4;
            v += arr[j] * pow(10, 3 - t++);
        }
        return v;
    }

    public static int pow(int x, int e) {
        int v = 1;
        for (int i = 0; i < e; i++) {
            v *= x;
        }
        return v;
    }
}