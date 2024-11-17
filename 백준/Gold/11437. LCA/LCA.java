import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer>[] graph;
    public static int[] p; // parent
    public static int[] d; // depth
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        p = new int[n + 1];
        d = new int[n + 1];
        visited = new boolean[n + 1];

        // 1. 각 노드의 깊이를 구하기
        dfs(1, 0);


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            sb.append(lca(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int node, int depth){
        visited[node] = true;
        d[node] = depth;

        for(Integer next : graph[node]){
            if(visited[next]) continue;
            p[next] = node;
            dfs(next, depth + 1);
        }
    }

    // least common ancestor
    public static int lca(int a, int b){
        // 먼저 깊이가 같은 노드로 이동
        while(d[a] != d[b]){
            if(d[a] < d[b]){
                b = p[b];
            }else{
                a = p[a];
            }
        }

        while(a != b){
            a = p[a];
            b = p[b];
        }

        return a;
    }
}