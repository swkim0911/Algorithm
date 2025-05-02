import java.util.*;
import java.io.*;


public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.c - o2.c);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Pair(a, b, c));
        }
        int[] parents = new int[v+1]; // parents[x]: x노드의 부모 노드
        for(int i = 0; i <= v; i++){
            parents[i] = i; // 초기화
        }

        int answer = 0;
        int time = 0;
        while (true){
            if(time == v-1) break;
            Pair cur = pq.poll();
            if(isDiffGroup(cur.a, cur.b, parents)){
                union(cur.a, cur.b, parents);
                answer += cur.c;
                time += 1;
            }
        }
        System.out.println(answer);
    }

    public static int getParent(int v, int[] p){
        if(p[v] == v) return v;

        return p[v] = getParent(p[v], p);
    }

    public static void union(int x, int y, int[] p){
        int p1 = getParent(x, p);
        int p2 = getParent(y, p);
        if(p1 < p2){
            p[p2] = p1;
        }else{
            p[p1] = p2;
        }
    }

    public static boolean isDiffGroup(int x, int y, int[] p){
        int p1 = getParent(x, p);
        int p2 = getParent(y, p);
        return p1 != p2;
    }

    static class Pair{
        int a;
        int b;
        int c;

        public Pair(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}



