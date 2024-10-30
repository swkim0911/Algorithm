import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);
            graph[s].add(new Pair(e, d));
        }

        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist); // 거리 기준으로 오름차순 정렬
        int[] d = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            d[i] = INF;
        }
        d[start] = 0;
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(d[cur.node] < cur.dist) continue;

            for(Pair next : graph[cur.node]){
                int nextDistance = cur.dist + next.dist;
                if (nextDistance < d[next.node]) {
                    d[next.node] = nextDistance;
                    pq.add(new Pair(next.node, nextDistance));
                }
            }
        }

        System.out.print(d[end]);
    }
}

class Pair{
    int node;
    int dist;

    public Pair(int n, int d) {
        this.node = n;
        this.dist = d;
    }
}
