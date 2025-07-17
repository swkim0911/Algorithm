import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Data data = new Data(st.nextToken(), Integer.parseInt(st.nextToken()));
            arr[i] = data;
        }
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            String chingho = getChingho(arr, power);
            sb.append(chingho).append("\n");
        }
        System.out.print(sb);
    }

    public static String getChingho(Data[] arr, int power) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (power <= arr[mid].limit) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return arr[start].chingho;
    }

}

class Data{
    String chingho;
    int limit;

    public Data(String chingho, int limit) {
        this.chingho = chingho;
        this.limit = limit;
    }
}
