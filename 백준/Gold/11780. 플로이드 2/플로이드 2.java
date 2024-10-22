import java.io.*;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] board = new int[n+1][n+1];
        int[][] path = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j){
                    board[i][j] = INF;
                }
            }
        }
        while (m-- > 0) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            board[a][b] = Math.min(board[a][b], c);
            path[a][b] = b;
        }

        for(int v = 1; v <= n; v++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(board[i][j] > board[i][v] + board[v][j]){
                        board[i][j] = board[i][v] + board[v][j];
                        path[i][j] = path[i][v];
                    }
                }
            }
        }

        for(int i  = 1 ; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == INF){
                    board[i][j] = 0;
                }
                sb.append(board[i][j]+" ");
            }
            sb.append("\n");
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == 0){
                    sb.append(0).append("\n");
                }else{
                    int cnt = 1;
                    StringBuilder p = new StringBuilder(i+" "); // 시작
                    int from = i;
                    while(from != j){
                        p.append(path[from][j] + " ");
                        from = path[from][j];
                        cnt++;
                    }
                    sb.append(cnt +" "+ p).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}