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
        int[] arr = new int[100_001];
        Arrays.fill(arr, -1);
        arr[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(arr[k] == -1){
            int cur = q.poll();
            int[] tmp = new int[]{cur - 1, cur + 1, cur * 2};
            for (int i = 0; i < 3; i++) {
                int nxt = tmp[i];
                if(nxt > 100_000 || nxt < 0) continue;
                int times = arr[cur];
                if(i != 2){
                    times += 1;
                }
                if(arr[nxt] != -1 && arr[nxt] < times) continue;
                arr[nxt] = times;
                q.add(nxt);
            }
        }
        System.out.println(arr[k]);
    }
}