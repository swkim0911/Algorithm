import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] split = br.readLine().split(" ");
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(arr);
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            
            if(exp(arr[0]) + exp(arr[1]) == exp(arr[2])){
                sb.append("right");
            }else{
                sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int exp(int x){
        return x*x;
    }
}