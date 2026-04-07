import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] graph = new ArrayList[v + 1]; //graph[x]: x에서 시작하는 간선들
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, c));
        }
        int[] dist = new int[v + 1]; // dist[x]: k에서 x까지 최단 거리
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.c - o2.c);
        Arrays.fill(dist, INF);
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (Pair nxt : graph[cur.b]) {
                int nextDist = cur.c + nxt.c;

                if (nextDist < dist[nxt.b]) {
                    dist[nxt.b] = nextDist;
                    pq.add(new Pair(nxt.b, nextDist));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);



    }

    static class Pair{
        int b;
        int c;

        public Pair(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}