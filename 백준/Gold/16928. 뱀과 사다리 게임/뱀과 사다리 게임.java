import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] board = new int[101]; // board[x]: x에서 도착하는 실제 위치
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Data cur = q.poll();
            if(cur.pos == 100) return cur.time;
            for (int i = 1; i <= 6; i++) {
                int nxt = cur.pos + i;
                if(nxt > 100) continue;
                nxt = board[nxt]; // nxt 위치에 사다리나 뱀이 있는 경우 이동
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new Data(nxt, cur.time + 1));
                }
            }

        }

        return -1;
    }
}

class Data{
    int pos; // 현재 위치
    int time; // 주사위 횟수 (최소)

    public Data(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}
