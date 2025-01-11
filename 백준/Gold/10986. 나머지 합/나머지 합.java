import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        long[] s = new long[n+1]; // 누적합
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken()) + s[i-1];
        }
        int[] remainArr = new int[n];
        for(int i = 0; i < n; i++){
            remainArr[i] = (int)(s[i+1] % m);
        }
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(remainArr[i] == 0) ans++;
            map.put(remainArr[i], map.getOrDefault(remainArr[i] ,0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans += getNC2(entry.getValue());
        }
        System.out.println(ans);
    }

    public static long getNC2(int n){
        return ((long)n * (n-1)) / 2;
    }
}

// 1 3 6 7 9