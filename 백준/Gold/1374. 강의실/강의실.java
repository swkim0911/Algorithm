import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(num, s, e);
        }
        Arrays.sort(lectures, (o1, o2) -> o1.s != o2.s ? o1.s - o2.s : o1.e - o2.e); // 끝나는 시간이 아니라 시작 시간 기준으로 오름차순 정렬하는 이유는. 하나의 방이 아니라 원한다면 방을 만들어 낼 수 있으니까. 시작 순으로 본다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].e);
        for (int i = 1; i < n; i++) {
            if(pq.peek() <= lectures[i].s){
                pq.poll();
            }
            pq.add(lectures[i].e);
        }
        System.out.println(pq.size());
    }

    static class Lecture{
        int num;
        int s;
        int e;

        public Lecture(int num, int s, int e) {
            this.num = num;
            this.s = s;
            this.e = e;
        }
    }
}