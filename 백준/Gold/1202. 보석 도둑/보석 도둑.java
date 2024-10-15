import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                jewels[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        TreeMap<Integer, Integer> tMap = new TreeMap<>(); // <가방 최대 무게, 중복 개수>
        for(int i = 0; i < k; i++){
            int weight = Integer.parseInt(br.readLine());
            tMap.put(weight, tMap.getOrDefault(weight, 0) + 1);
        }

        Arrays.sort(jewels, (o1,o2) -> o2[1] - o1[1]); // 비싼게 앞으로(내림차순 정렬)

        long answer = 0;
        for(int i = 0; i < n; i++){
            int[] jewel = jewels[i];
            Integer bag = tMap.ceilingKey(jewel[0]); // jewel의 무게보다 큰 것 중 가장 작은 무게, 또는 같은 무게
            if(bag != null){
                answer += jewel[1];
                int cnt = tMap.get(bag); // 중복 개수
                if(cnt > 1){
                    tMap.replace(bag, cnt - 1);
                }else{
                    tMap.remove(bag);
                }
            }

        }
        System.out.print(answer);
    }
}