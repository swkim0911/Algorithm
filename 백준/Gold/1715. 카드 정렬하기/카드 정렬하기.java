import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (pq.size() > 1) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            answer += first + second;
            pq.add(first + second);
        }
        System.out.println(answer);
    }

}