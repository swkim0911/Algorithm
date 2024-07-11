import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1010];
        for (int i = 0; i <= 1000; i++) {
            if (i % 4 == 0) {
                arr[i+1] = 1;
                arr[i+3] = 1;
            }
        }

        int N = Integer.parseInt(br.readLine());

        if (arr[N] == 1) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }

}
