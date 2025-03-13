import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static ArrayList<Data>[] tree;
    public static boolean[] visited;
    public static int answer = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            tree[a].add(new Data(b, c));
            tree[b].add(new Data(a, c));
        }
        for (int s = 1; s <= n; s++) {
            visited = new boolean[n + 1];
            visited[s] = true;
            dfs(s, 0);
            visited[s] = false;
        }
        System.out.println(answer);
    }

    public static void dfs(int node, int sum) {
        answer = Math.max(answer, sum);

        for (Data nxt : tree[node]) {
            if(visited[nxt.to]) continue;
            visited[nxt.to] = true;
            dfs(nxt.to, sum + nxt.w);
            visited[nxt.to] = false;
        }
    }
}

class Data{
    int to;
    int w;

    public Data(int to, int w) {
        this.to = to;
        this.w = w;
    }
}