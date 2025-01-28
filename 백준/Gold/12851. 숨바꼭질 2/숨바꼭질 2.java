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
        int cnt = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){ // 처음 만나자마자 끝.
            int cur = q.poll();
            int[] tmp = new int[]{cur - 1, cur + 1, cur * 2};
            for (int i = 0; i < 3; i++) {
                int nxt = tmp[i];
                if(nxt > 100_000 || nxt < 0) continue;
                if(arr[nxt] != -1 && arr[nxt] < arr[cur] + 1) continue;
                arr[nxt] = arr[cur] + 1;
                q.add(nxt);
                if(nxt == k) cnt++;
            }
        }

        System.out.println(arr[k]);
        System.out.println(cnt == -1 ? 1 : cnt + 1);
    }
}