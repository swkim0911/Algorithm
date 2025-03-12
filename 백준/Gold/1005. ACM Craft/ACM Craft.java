import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] indegree = new int[n + 1]; // indegree[x]: x로 들어오는 간선 수

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                graph[prev].add(next);
                indegree[next]++;
            }
            int w = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(indegree[i] == 0) q.add(i);
            }
            int[] sum = new int[n + 1];
            while (!q.isEmpty()) {
                Integer cur = q.poll();
                sum[cur] += times[cur];
                for(int next : graph[cur]){
                    indegree[next]--;
                    sum[next] = Math.max(sum[next], sum[cur]);
                    if(indegree[next] == 0) q.add(next);
                }
            }
            sb.append(sum[w]).append("\n");
        }
        System.out.print(sb);
    }
}
// 내 이후에 아무것도 넣을 필요 없으면 뽑기
// 1 -> 3, 2 -> 3  3입장에서 내 앞에1,2 가 있어야 함.

