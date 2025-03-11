import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Info(a, b, c));
        }
        int[] arr = new int[n + 1]; //arr[x]: node x의 부모
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int answer = 0;
        int cnt = 0;
        while (cnt != n - 2) { //
            Info info = pq.poll();
            if (!isGroup(info.a, info.b, arr)) {
                cnt++;
                union(info.a, info.b, arr);
                answer = answer + info.c;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroup(int v1, int v2, int[] arr) {
        int p1 = getParent(v1, arr);
        int p2 = getParent(v2, arr);
        return p1 == p2;
    }

    public static int getParent(int v, int[] arr){
        if(v == arr[v]) return v;
        return arr[v] = getParent(arr[v], arr);
    }

    public static void union(int v1, int v2, int[] arr) {
        int p1 = getParent(v1, arr);
        int p2 = getParent(v2, arr);
        if(p1 < p2){
            arr[p2] = p1;
        }else{
            arr[p1] = p2;
        }
    }
}

class Info{
    int a;
    int b;
    int c;

    public Info(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
// mst -> 크루스칼 알고리즘

