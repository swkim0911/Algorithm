import javax.print.attribute.standard.PrinterResolution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] graph = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Pair(end, w));
        }

        // 다익스트라
        int[] d = new int[v + 1];// start v에서 각 v에 대한 최단 거리
        for(int i = 1; i <= v; i++){
            d[i] = INF;
        }
        d[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.dist - o2.dist);
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(d[cur.node] < cur.dist) continue;
            for(Pair nxt : graph[cur.node]){
                int nxtNode = nxt.node;
                int nxtDist = cur.dist + nxt.dist;
                if(nxtDist < d[nxtNode]){
                    d[nxtNode] = nxtDist;
                    pq.add(new Pair(nxtNode, nxtDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++){
            if(d[i] == INF){
                sb.append("INF");
            }else{
                sb.append(d[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int n, int start, int[][] graph){
        int[] d = new int[n + 1]; // 시작점에서 각 노드까지 거리
        boolean[] visited = new boolean[n + 1]; // 방문했다는 건 최단거리가 확장됐다는 거임
        for(int i = 0; i <= n; i++){
            d[i] = graph[start][i];
        }
        visited[start] = true;
        for(int i = 0; i < n-2; i++){
            //1. 최단 거리 찾기
            int v = 0;
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    if(d[j] < min){
                        v = j;
                        min = d[j];
                    }
                }
            }
            visited[v] = true;
            //2. 최단 거리를 갖는 노드를 거치는 것과 원래 거리 비교해서 갱신
            for(int j = 1; j <= n; j++) {
                if(!visited[j]){
                    if (d[v] + graph[v][j] < d[j]) {
                        d[j] = d[v] + graph[v][j];
                    }
                }
            }
        }
    }
}

class Pair{
    int node;
    int dist;

    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}