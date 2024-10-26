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
        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n];
        int[] dp = new int[n]; // dp[x]: 수열에 index x 번 까지 봤을 때 가장 긴 증가하는 수열의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 초기화. 처음에는 모두 최장 길이가 1이다.
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(cost[j] < cost[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int val : dp){
            answer = Math.max(val, answer);
        }
        System.out.println(answer);
    }

    public static void dijkstra(int n, int start, ArrayList<Pair>[] graph) {
        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++){
            d[i] = INF;
        }
        d[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.dist - o2.dist);
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.dist;
            if(d[node] < dist) continue;
            for (int i = 0; i < graph[node].size(); i++) {
                int next = graph[node].get(i).node;
                int nextDist = dist + graph[node].get(i).dist;
                if (nextDist < d[next]) {
                    d[next] = nextDist;
                    pq.add(new Pair(next, nextDist));
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

