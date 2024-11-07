import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;
    public static ArrayList<Data>[] graph;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int x = Integer.parseInt(split[2]);

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);
            graph[s].add(new Data(e, d));
        }

        // 1. x에서 모든 지점으로 돌아가는 최단거리 -> 다익스트라
        arr = dijkstra(x, n);

        for(int i = 1; i <= n; i++){
            if(i != x){
                int[] result = dijkstra(i, n);
                arr[i] += result[x];
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);

    }

    public static int[] dijkstra(int start, int n) {
        int[] d = new int[n + 1];
        
        for(int i = 0;  i <= n; i++){
            d[i] = INF;
        }
        d[start] = 0;

        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist); // 거리기준으로 오름차순
        pq.add(new Data(start, 0));

        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            if(d[cur.end] < cur.dist) continue;
            for(Data nxt : graph[cur.end]){
                int nextDistance = cur.dist + nxt.dist;
                if(nextDistance < d[nxt.end]){
                    d[nxt.end] = nextDistance;
                    pq.add(new Data(nxt.end, nextDistance));
                }
            }
        }
        
        return d;
    }

}

// 1. x 에서 모든 지점으로 돌아가는 최단거리
// 2. 각 점에서 x로 가는 다익스트라

class Data{
    int end;
    int dist;

    public Data(int e, int d){
        this.end = e;
        this.dist = d;
    }
}