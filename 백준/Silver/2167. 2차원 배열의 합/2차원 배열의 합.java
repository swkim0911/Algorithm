import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] pSum = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pSum[i][j] = arr[i-1][j-1] + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(pSum[x][y] - pSum[x][j-1] - pSum[i-1][y] + pSum[i-1][j-1]).append("\n");
        }
        System.out.println(sb);
    }

    static void print(int[][] arr, int n, int m){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

