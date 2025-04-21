import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int exc = Math.round((float) (n * 15) / 100);

        int sum = 0;

        for (int i = exc; i < n - exc; i++) {
            sum += arr[i];
        }
        int answer = n == 0 ? 0 : Math.round((float) sum / (n - 2 * exc));

        System.out.println(answer);

    }

}

