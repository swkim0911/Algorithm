import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, e));
        }
        lectures.sort((o1, o2) -> o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s); // 시작 시간 기준 오름차순. 같다면 끝나는 시간 기준 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures.get(0).e);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures.get(i).s) {
                pq.poll();
            }
            pq.add(lectures.get(i).e);
        }
        System.out.println(pq.size());
    }

    static class Lecture {
        int s; // 시작시간
        int e; // 끝나는 시간

        public Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}