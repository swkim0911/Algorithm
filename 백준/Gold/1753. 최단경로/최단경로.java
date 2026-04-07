import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1]; // graph[x]: x에서 시작하는 간선들 정보
        for(int i = 0; i < V + 1; i++){
            graph[i] = new ArrayList<>();
        }
        // 0. 그래프 구성하기
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        // 1. 다익스트라 알고리즘
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        // 1.1 pq 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
            return o1.weight - o2.weight;
        });
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight) continue; // 고려 대상이 이전 기록보다 이미 큰 경우는 볼 필요가 없다

            for(Node nxt : graph[cur.to]){
                int nxtDistance = cur.weight + nxt.weight;
                if(nxtDistance < dist[nxt.to]){
                    dist[nxt.to] = nxtDistance;
                    pq.add(new Node(nxt.to, nxtDistance));
                }
            }
        }

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                    System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}

class Node{
    int to;
    int weight;

    public Node(int t, int w){
        this.to = t;
        this.weight = w;
    }
}