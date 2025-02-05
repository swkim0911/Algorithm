import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2]; // arr[x][0]: d, arr[x][1]: p
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int p = Integer.parseInt(split[0]);
            int d = Integer.parseInt(split[1]);
            arr[i][0] = d;
            arr[i][1] = p;
        }
        Arrays.sort(arr, (o1,o2) -> {
            if(o2[1] == o1[1]){
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        }); // 강연료 기준 내림차순. 같으면 날짜 기준 내림차순
        boolean[] check = new boolean[10_001];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j >= 1; j--) {
                if(!check[j]){
                    check[j] = true;
                    answer += arr[i][1];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
// 강연료가 높은 것들을 먼저 봐서 d 날짜에 보기 -> 강연료가 높은 것들을 먼저 보고 d 날짜에 최대한 가까운 날짜에 넣기(최대한 미루는게 최선)

