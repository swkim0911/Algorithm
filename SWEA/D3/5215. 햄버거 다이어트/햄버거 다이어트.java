import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution
{
    static int max;

    static int n;
    static int l;
    static Ingredient[] ingredients;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            String[] split = br.readLine().split(" ");
            max = Integer.MIN_VALUE;
            n = Integer.parseInt(split[0]);
            l = Integer.parseInt(split[1]);
            ingredients = new Ingredient[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                ingredients[i] = new Ingredient(score, cal);
            }
            dfs(0, 0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cnt, int cal, int score) {
        if(cal > l) return;
        if (cnt == n) {
            max = Math.max(max, score);
            return;
        }
        dfs(cnt + 1, cal + ingredients[cnt].cal, score + ingredients[cnt].score);
        dfs(cnt + 1, cal, score);
    }
}

class Ingredient{
    int score;
    int cal;

    public Ingredient(int score, int cal) {
        this.score = score;
        this.cal = cal;
    }
}
