import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Path> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(e > d) continue; //  e > d 인 지름길은 필요없음.
            if(e - s < dist) continue; // 지름길이 더 멀 경우 필요없음.
            list.add(new Path(s, e, dist));
        }
        Collections.sort(list, (o1, o2) -> o1.s - o2.s); // 시작점을 기준으로 오름차순 정렬
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            answer = Math.min(answer, cur.dist + d - cur.pos); // 현재까지 이동 거리 + 현재 위치에서 목표 지점까지 거리
            for (Path path : list) {
                if(path.s < cur.pos) continue; // 지름길이 현재 위치보다 뒤에 있는 경우
                int go = path.s - cur.pos; // 현재 위치에서 지름길까지 가는 거리
                int nextPos = path.e;
                int nextDist = cur.dist + go + path.dist; // 총 이동 거리
                q.add(new Node(nextPos, nextDist));
            }
        }
        System.out.println(answer);
    }
}

class Node{
    int pos; // 현재 위치
    int dist; // 거리 총합

    public Node(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }
}

class Path{
    int s;
    int e;
    int dist;

    public Path(int s, int e, int dist) {
        this.s = s;
        this.e = e;
        this.dist = dist;
    }
}

