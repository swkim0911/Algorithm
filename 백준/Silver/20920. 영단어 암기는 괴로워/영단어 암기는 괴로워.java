import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1,o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                if(o1.getKey().length() == o2.getKey().length()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getKey().length() - o1.getKey().length();
            }
            return o2.getValue() - o1.getValue();
        });

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            sb.append(entry.getKey()).append("\n");
        }
        System.out.print(sb);
    }
}