import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(br.readLine());
        int[] sample = new int[l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            sample[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[l];
            for (int i = 0; i < l; i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            if(isSame(sample, tmp, l)){
                cnt++;
                for (int i = 0; i < l; i++) {
                    sb.append(tmp[i]).append(" ");
                }
                sb.append("\n");
            }
        }
        sb.insert(0, cnt + "\n");
        System.out.print(sb);
    }

    public static boolean isSame(int[] sample, int[] tmp, int l) {
        int[] right = new int[l * 2]; // 정방향
        for (int i = 0; i < l; i++) {
            right[i] = tmp[i];
            right[i+l] = tmp[i];
        }
        int[] left = new int[l * 2]; // 역방향
        for (int i = 0; i < l; i++) {
            left[i] = tmp[i] % 2 == 0 ? (tmp[i] == 2 ? 4 : 2) : (tmp[i] == 3 ? 1 : 3);
            left[i + l] = left[i];
        }

        // 정방향
        for (int s = 0; s < l; s++) {
            boolean same = true;
            int j = 0;
            for (int i = s; i < s + l; i++) {
                if(sample[j++] != right[i]){
                    same = false;
                    break;
                }
            }
            if(same) return true;
        }

        // 역방향
        for (int s = 2 * l - 1; s >= l; s--) {
            boolean same = true;
            int j = 0;
            for (int i = s; i > s - l; i--) {
                if(sample[j++] != left[i]){
                    same = false;
                    break;
                }
            }
            if(same) return true;
        }
        return false;
    }
}
