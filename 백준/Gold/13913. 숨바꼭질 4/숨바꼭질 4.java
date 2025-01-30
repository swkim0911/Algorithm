import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] arr = new int[100_001]; // arr[x]: n -> x로 이동하는 가장 빠른 시간
        Arrays.fill(arr, -1);
        arr[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int[] path = new int[100_001]; // path[x]: x위치 이전 위치
        path[n] = -1; // 시작점
        while(arr[k] == -1){
            int cur = q.poll();
            int[] tmp = new int[]{cur - 1, cur + 1, cur * 2};
            for (int i = 0; i < 3; i++) {
                int nxt = tmp[i];
                if(nxt > 100_000 || nxt < 0) continue;
                if(arr[nxt] != -1) continue; // 이미 방문한 경우
                arr[nxt] = arr[cur] + 1;
                path[nxt] = cur;
                q.add(nxt);
            }
        }
        StringBuilder sb = new StringBuilder();
        int before = k;
        while(before != -1){
            sb.insert(0, before+" ");
            before = path[before];
        }
        System.out.println(arr[k]);
        System.out.print(sb);
    }
}
