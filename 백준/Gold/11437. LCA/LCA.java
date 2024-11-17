import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer>[] graph;
    public static int[] p;
    public static int[] d;
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
        d[node] = depth;
        visited[node] = true;

        for(Integer next : graph[node]){
            if(visited[next]) continue;
            p[next] = node;
            dfs(next, depth + 1);
        }
    }

    public static int lca(int a, int b){
        // 1. 두 노드의 깊이를 같게 올리기
        while(d[a] != d[b]){
            if(d[a] < d[b]){ // b의 깊이가 더 큰 경우 b를 올린다.
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