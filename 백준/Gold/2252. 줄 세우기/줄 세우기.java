import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            indegree[to]++;
            graph[from].add(to);
        }
        Queue<Integer> q = new LinkedList<>(); // fifo니까 순서를 지킨다. 큐에 들어간 번호는 중복되서 들어갈 수 없다.
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            result.add(cur);
            for(int nxt : graph[cur]){
                indegree[nxt]--;
                if(indegree[nxt] == 0) q.add(nxt);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v).append(" ");
        }
        System.out.print(sb);
    }
}
// 내 이후에 아무것도 넣을 필요 없으면 뽑기
// 1 -> 3, 2 -> 3  3입장에서 내 앞에1,2 가 있어야 함.

