import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static StringBuilder sb = new StringBuilder();

    static int n;
    static Point sPoint;
    static Point dPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            List<Point> stores = new ArrayList<>(); // 편의점 list
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    sPoint = new Point(x, y);
                } else if (i == n + 1) {
                    dPoint = new Point(x, y);
                }else{
                    stores.add(new Point(x, y));
                }
            }
            bfs(stores);
        }
        System.out.print(sb);
    }

    static void bfs(List<Point> stores) {
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(sPoint);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if(getDistance(cur, dPoint) <= 1000){
                sb.append("happy").append("\n");
                return;
            }
            // 현재 위치에서 목적지까지 1000m 초과인 경우 편의점에 가야함
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    Point store = stores.get(i);
                    int distance = getDistance(cur, store);
                    if(distance <= 1000){
                        visited[i] = true;
                        q.add(store);
                    }
                }
            }
        }
        sb.append("sad").append("\n");
    }

    private static int getDistance(Point to, Point from) {
        return Math.abs(to.x - from.x) + Math.abs(to.y - from.y);
    }
}