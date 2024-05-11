import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
    static final int LENGTH = 8;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 10;
        while (testcase-- > 0) {
            Deque<Integer> deque = new ArrayDeque<>();
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < LENGTH; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            label : while (true) {
                for (int i = 1; i <= 5; i++) {
                    int head = deque.pollFirst();
                    deque.addLast(Math.max(head - i, 0));
                    if(deque.getLast() == 0) break label;
                }
            }
            sb.append("#").append(t);
            while (!deque.isEmpty()) {
                Integer head = deque.pollFirst();
                sb.append(" ").append(head);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

