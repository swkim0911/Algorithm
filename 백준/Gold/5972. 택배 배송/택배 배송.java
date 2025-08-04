import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }
        int[] costs = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            costs[i] = INF;
        }
        costs[1] = 0; // 초기화. 출발점에서 출발점까지 거리는 0이고, 나머지는 INF.

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (Pair nxt : graph[cur.node]) {
                if (cur.cost + nxt.cost < costs[nxt.node]) {
                    costs[nxt.node] = cur.cost + nxt.cost;
                    pq.add(new Pair(nxt.node, cur.cost + nxt.cost));
                }

            }
        }

        System.out.println(costs[n]);
    }

    static class Pair{
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}