import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if(i == n - 1){
                list.add(i+1);
            }else{
                list.add(arr[i], i + 1);
            }
        }
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}