import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        int[] cnt = new int[n + 1];
        int max = 0;

        for (int v = 1; v < n + 1; v++) {
            cnt[v] = bfs(v);
            max = Math.max(max, cnt[v]);
        }

        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= n; v++) {
            if(cnt[v] == max) sb.append(v).append(" ");
        }
        System.out.print(sb);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cut = q.poll();

            for (int nxt : graph[cut]) {
                if(visited[nxt]) continue;
                visited[nxt] = true;
                q.add(nxt);
                cnt += 1;
            }
        }
        return cnt;
    }

}

