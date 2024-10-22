import java.io.*;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] board = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j){
                    board[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < m; i++){
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            board[a][b] = Math.min(board[a][b], c);
        }
        for(int v = 1; v <= n; v++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i != j){
                        board[i][j] = Math.min(board[i][j], board[i][v] + board[v][j]);
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == INF){
                    board[i][j] = 0;
                }
                sb.append(board[i][j]);
                if(j != n){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}