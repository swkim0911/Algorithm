import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        int[] arr = new int[s + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= s; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int i = num; i <= s; i += num) {
                    arr[i] = change(arr[i]); // switch
                }
            } else if (gender == 2) {
                arr[num] = change(arr[num]);
                int left = num - 1;
                int right = num + 1;
                while(isOk(left, right, s)){
                    if(arr[left] != arr[right]) break;
                    arr[left] = change(arr[left]);
                    arr[right] = change(arr[right]);
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= s; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0){
                sb.append("\n");
            }
        }

        System.out.print(sb.toString().trim());

    }

    public static boolean isOk(int left, int right, int s) {
        return left >= 1 && right <= s;
    }

    public static int change(int x) {
        return x == 1 ? 0 : 1;
    }
}