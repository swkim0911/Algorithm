import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }
        int target = sum - 100;
        label : for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(arr[i] + arr[j] == target){
                    arr[i] = -1;
                    arr[j] = -1;
                    break label;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if(arr[i] != -1){
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.print(sb);

    }
}