import java.util.*;
import java.io.*;


public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1]; // dist[x]: 출발지에서 x까지 최단거리
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.node - o2.node);
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(dist[cur.node] < cur.dist) continue;

            for(Pair next : graph[cur.node]){
                int nextDistance = cur.dist + next.dist; // 현재 노드를 거쳐서 next 노드까지 가는 거리
                if (nextDistance < dist[next.node]) {
                    dist[next.node] = nextDistance;
                    pq.add(new Pair(next.node, nextDistance));
                }
            }
        }

        int answer = dist[end];
        System.out.println(answer);
    }

    static class Pair{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}



