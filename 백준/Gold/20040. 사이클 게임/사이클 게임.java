import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        boolean hasCycle = false;
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if(hasCycle) continue;
            if(isCycle(p, a, b)){
                hasCycle = true;
                answer = i;
            }else{
                union(p, a, b);
            }
        }

        System.out.println(answer);
    }

    public static boolean isCycle(int[] p, int a, int b){
        int v1 = getParent(p, a);
        int v2 = getParent(p, b);
        return v1 == v2;
    }

    public static int getParent(int[] p, int node){
        if(p[node] == node) return node;
        return p[node] = getParent(p, p[node]);
    }

    public static void union(int[] p, int a, int b){
        int v1 = getParent(p, a);
        int v2 = getParent(p, b);
        if(v1 < v2){
            p[v2] = v1;
        }else{
            p[v1] = v2;
        }
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

