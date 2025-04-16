import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Integer[] priorities = new Integer[n];
            Queue<Data> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                q.add(new Data(i, priorities[i]));
            }
            Arrays.sort(priorities, (o1, o2) -> o2 - o1);
            int cursor = 0;
            while (!q.isEmpty()) {
                Data cur = q.peek();
                if (cur.priority == priorities[cursor]) {
                    q.poll();
                    cursor += 1;
                    if (m == cur.idx) {
                        sb.append(cursor).append("\n");
                        break;
                    }
                } else {
                    q.add(q.poll());
                }
            }
        }
        System.out.print(sb);
    }

    public static class Data{
        int idx;
        int priority;

        public Data(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}

