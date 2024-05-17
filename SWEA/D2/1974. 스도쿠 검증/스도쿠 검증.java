import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int SIZE = 9;

    public static void main(String[] arges) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int[][] board = new int[SIZE][SIZE];
            int ans = 1;
            for (int i = 0; i < SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 가로 check
            label: for (int i = 0; i < SIZE; i++) {
                boolean[] check = new boolean[SIZE];
                for (int j = 0; j < SIZE; j++) {
                    if(check[board[i][j]-1]) {
                        ans = 0;
                        break label;
                    }
                    check[board[i][j]-1] = true;
                }
            }
            // 세로 check
            if(ans == 1){
                label: for (int i = 0; i < SIZE; i++) {
                    boolean[] check = new boolean[SIZE];
                    for (int j = 0; j < SIZE; j++) {
                        if(check[board[j][i]-1]) {
                            ans = 0;
                            break label;
                        }
                        check[board[j][i]-1] = true;
                    }
                }
            }
            if(ans == 1){
                label: for (int i = 0; i < SIZE; i += 3) {
                    for (int j = 0; j < SIZE; j += 3) {
                        boolean[] check = new boolean[SIZE];
                        for (int k = i; k < 3; k++) {
                            for (int l = j; l < 3; l++) {
                                if(check[board[k][l]-1]){
                                    ans = 0;
                                    break label;
                                }
                                check[board[k][l]-1] = true;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
