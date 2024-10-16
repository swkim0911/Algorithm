import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[n][2]; // jewels[x][0]: x번째 보석 무게, jewels[x][1]: x번째 보석 가격
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewels, (o1,o2) -> o2[1] - o1[1]); // 가격을 기준으로 내림차순 정렬
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for(int i = 0; i < k; i++){
            int weight = Integer.parseInt(br.readLine());
            tMap.put(weight, tMap.getOrDefault(weight, 0) + 1);
        }

        long answer = 0;

        for(int[] jewel : jewels){
            Integer bag = tMap.ceilingKey(jewel[0]);
            if(bag != null){
                answer += jewel[1];
                int cnt = tMap.get(bag);
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