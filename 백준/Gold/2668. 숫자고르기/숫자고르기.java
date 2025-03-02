import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited; // 묶음이 생긴 정수
    static int[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(br.readLine());
            graph[i] = v;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(visited[i]){
                cnt++;
                sb.append(i).append("\n");
            }
        }
        sb.insert(0, cnt + "\n");
        System.out.print(sb.toString().trim());
    }

    public static void dfs(int node) {
        Set<Integer> top = new HashSet<>();
        Set<Integer> bottom = new HashSet<>();
        while (!top.contains(node) && !visited[node]) {
            top.add(node);
            node = graph[node];
            bottom.add(node);
        }
        if (top.size() == bottom.size()) {
            boolean flag = true;
            for (Integer num : top) {
                if(!bottom.contains(num)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(Integer num : top){
                    visited[num] = true;
                }
            }
        }

    }
}