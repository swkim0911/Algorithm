import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Pair>[] graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Pair(e, d));
        }
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        int[] d = new int[n + 1];
        int[] pre = new int[n + 1];

        Arrays.fill(d, INF);
        Arrays.fill(pre, INF);
        d[start] = 0;
        pre[start] = start;

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.dist - o2.dist);
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(d[cur.node] < cur.dist) continue;

            for(Pair nxt : graph[cur.node]){
                int nxtDist = cur.dist + nxt.dist;
                if(nxtDist < d[nxt.node]){
                    d[nxt.node] = nxtDist;
                    pre[nxt.node] = cur.node;
                    pq.add(new Pair(nxt.node, nxtDist));
                }
            }
        }
        int cnt = 1;
        int node = end;
        StringBuilder sb = new StringBuilder(String.valueOf(end));
        while(node != start){
            node = pre[node];
            sb.insert(0, node+" ");
            cnt++;
        }

        System.out.println(d[end]);
        System.out.println(cnt);
        System.out.print(sb);
    }
    // [0,1,3, 9]
    // 1 -> 2: 1
    // 1 -> 3: 5
    // 2 -> 3: 2
    // 2 -> 4: 10
    // 3- > 4: 4
}

class Pair{
    int node;
    int dist;

    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}