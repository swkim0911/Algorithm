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

        ArrayList<Integer>[] graph = new ArrayList[n+1]; // graph[i].get(j): i번째 노드에서 j번째 노드로 방향을 갖는 엣지

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1]; // indegree[i]: i번째 노드로 방향이 향하는 엣지 수

        while(m-- >0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for(int nxt : graph[cur]){
                indegree[nxt]--;
                if(indegree[nxt] == 0) q.add(nxt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int val : result){
            sb.append(val).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

