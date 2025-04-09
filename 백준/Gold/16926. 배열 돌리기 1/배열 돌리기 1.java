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
        int r = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(r-- > 0){
            board = rotate(n,m,board);
        }
        print(n, m, board);
    }

    public static void print(int n, int m, int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int n, int m, int[][] board){

        int[][] tmp = new int[n][m];

        for (int out = 0; out < Math.min(m / 2, n / 2); out++) { // out: 반시계 회전할 경로의 x좌표 인덱스)
            //왼 세로
            for (int i = out + 1; i < n - out; i++) {
                tmp[i][out] = board[i-1][out];
            }
            //아래 가로
            for (int j = out + 1; j < m - out; j++) {
                tmp[n-out-1][j] = board[n-out-1][j - 1];
            }
            //오 세로
            for (int i = n - out - 2; i >= out; i--){
                tmp[i][m - out - 1] = board[i+1][m - out - 1];
            }
            //위 가로
            for(int j = m - out - 2; j >= out; j--){
                tmp[out][j] = board[out][j+1];
            }
        }


        return tmp;
    }
}
/**
 * 1 2 3 4 5 6
 * 1 2 3 4 5 6
 * 1 2 3 4 5 6
 * 1 2 3 4 5 6
 */

/**
 * 1 2
 * 1 2
 * 1 2
 */