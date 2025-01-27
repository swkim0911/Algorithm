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
            for(int nxt : new int[]{cur-1, cur+1, cur*2}){
                if(nxt > 100_000 || nxt < 0) continue;
                if(arr[nxt] != -1) continue;
                arr[nxt] = arr[cur] + 1;
                q.add(nxt);
            }
        }
        System.out.println(arr[k]);
    }
}



class Data{
    int v;
    int t;

    public Data(int v, int t) {
        this.v = v;
        this.t = t;
    }

}

// 5
// 4 6 10
// 9 11 20
// 18
// 17

