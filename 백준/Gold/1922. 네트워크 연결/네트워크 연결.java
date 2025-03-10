import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            pq.add(new Data(a, b, c));
        }

        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int cnt = 0;

        while (cnt != n - 1) { // 모든 노드(n개)를 연결하는 간선의 수: n-1
            Data data = pq.poll();
            if (!isGroup(data.a, data.b, parents)) {
                cnt++;
                union(data.a, data.b, parents);
                answer += data.c;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroup(int a, int b, int[] parents) {
        int p1 = getParent(a, parents);
        int p2 = getParent(b, parents);
        return p1 == p2;
    }

    public static int getParent(int v, int[] parents) {
        if(parents[v] == v) return v;
        return parents[v] = getParent(parents[v], parents);
    }

    public static void union(int v1, int v2, int[] parents) {
        int p1 = getParent(v1, parents);
        int p2 = getParent(v2, parents);
        if (p1 < p2) {
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
        }
    }
}

class Data{
    int a;
    int b;
    int c;

    public Data(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
// dfs
