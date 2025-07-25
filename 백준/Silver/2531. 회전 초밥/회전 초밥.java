import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>(); // <종류, 개수>
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            int kind = Integer.parseInt(br.readLine());
            arr[i] = kind;
            arr[i+n] = kind;
        }
        int answer = Integer.MIN_VALUE;
        for (int s = 0; s < n; s++) {
            if(s == 0){
                for (int i = 0; i < k; i++) {
                    int kind = arr[s + i];
                    map.put(kind, map.getOrDefault(kind, 0) + 1);
                }
                int totalKinds = map.size() + (map.containsKey(c) ? 0 : 1);
                answer = Math.max(answer, totalKinds);
            }else{
                int beforeKind = arr[s - 1]; // 삭제
                map.replace(beforeKind, map.get(beforeKind) - 1);
                if (map.get(beforeKind) == 0) {
                    map.remove(beforeKind);
                }
                int curKind = arr[s + k - 1];
                map.put(curKind, map.getOrDefault(curKind, 0) + 1);

                int totalKinds = map.size() + (map.containsKey(c) ? 0 : 1);
                answer = Math.max(answer, totalKinds);
            }
        }
        System.out.println(answer);
    }

    public static void print(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("========");
    }
}
