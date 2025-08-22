import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; // graph[a]: a가 지어졌을 때, 지을 수 있는 건물들
        ArrayList<Integer>[] parents = new ArrayList[n + 1]; // parents[a]: a보다 먼저 지어져야 할 건물
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            parents[i] = new ArrayList<>();
        }
        int[] degrees = new int[n+1]; // degrees[x]: x 건물보다 먼저 지어져야 할 건물 수
        int[] times = new int[n+1]; // times[x]: x 건물을 짓는데 걸리는 시간
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int prev;
            while ((prev = Integer.parseInt(st.nextToken())) != -1) {
                // 앞에 있어야 할 건물
                graph[prev].add(i);
                parents[i].add(prev);
                degrees[i] += 1;
            }
        }
        int[] answer = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(degrees[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            int max = 0;
            for(Integer p : parents[cur]){
                max = Math.max(max, answer[p]);
            }
            answer[cur] = max + times[cur];

            for (int nxt : graph[cur]) {
                degrees[nxt] -= 1;
                if(degrees[nxt] == 0){
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

}