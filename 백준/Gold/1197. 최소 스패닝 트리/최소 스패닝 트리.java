import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int to;
    int from;
    int value;

    public Node(int to, int from, int value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int v = Integer.parseInt(split[0]);
        int e = Integer.parseInt(split[1]);
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, w));
        }
        Collections.sort(list);
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int to = find(node.to);
            int from = find(node.from);
            if (!isSameParent(to, from)) {
                total += node.value;
                union(node.to, node.from);
            }
        }
        System.out.println(total);
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}