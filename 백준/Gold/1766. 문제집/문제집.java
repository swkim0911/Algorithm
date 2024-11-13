import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; // for(Integer b : graph[a]): 문제 a는 b번 문제보다 먼저 풀어야 한다.
        int[] pointed = new int[n + 1]; // pointed[x]: x 문제를 가리키는 노드 수(x 문제보다 먼저 풀어야 하는 문제 수)

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            graph[a].add(b);
            pointed[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int i = 1; i <= n; i++){
            if(pointed[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Integer cur = pq.poll();
            sb.append(cur+" ");
            for(Integer nxt : graph[cur]){
                pointed[nxt]--;
                if(pointed[nxt] == 0){
                    pq.add(nxt);
                }
            }
        }
        System.out.print(sb.toString().trim());
    }
}
/**
 * 위상 정렬
 *
 */
