import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            arr[i][0] = x;
            arr[i][1] = y;
        }
        arr[n] = arr[0];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((double)arr[i][1])*arr[i+1][0];
            sum -= ((double)arr[i][0])*arr[i+1][1];
        }
        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}