import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Pair(e, d));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        pq.add(new Pair(start, 0));
        int[] distance = new int[n + 1]; // distance[x]: start에서 x까지 최소 거리
        Arrays.fill(distance, INF);
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(distance[cur.v] < cur.d) continue;

            for(Pair nxt : graph[cur.v]){
                int nextDistance = cur.d + nxt.d;
                if(nextDistance < distance[nxt.v]){
                    distance[nxt.v] = nextDistance;
                    pq.add(new Pair(nxt.v, nextDistance));
                }
            }
        }

        System.out.println(distance[end]);
    }
}

class Pair{
    int v; // vertex
    int d; // distance

    public Pair(int v, int d){
        this.v = v;
        this.d = d;
    }

}

