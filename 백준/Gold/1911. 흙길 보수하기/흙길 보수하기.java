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
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Puddle> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.s == o2.s){
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Puddle(s, e));
        }
        int right = 0; // 현재 널빤지의 가장 오른쪽 위치의 한 칸 앞
        int answer = 0;

        while (!pq.isEmpty()) {
            Puddle cur= pq.poll();
            if(cur.e <= right) continue;
            int cnt;
            if(right <= cur.s){
                cnt = ((cur.e - cur.s) + (l - 1)) / l; // cur.e - cur.s -> 덮어야 하는 영역의 넓이. // (l-1) -> 올림을 위한 장치
                right = cur.s + (l * cnt);
            }else{
                cnt = ((cur.e - right) + (l - 1)) / l;
                right = right + (l*cnt);

            }
            answer += cnt;
        }

        System.out.println(answer);
    }

    static class Puddle {
        int s,e;

        public Puddle(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    // 10억 -> 3초 이상 -> time out

    // 널빤지를 최소로 사용 -> 최대한 하나의 널빤지가 여러곳에 영향을 미치게, 잉여없이
}

