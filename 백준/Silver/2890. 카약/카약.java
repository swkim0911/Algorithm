import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ranks = new int[10];
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int rank = 1;
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int j = col - 2; j >= 1; j--) {
            boolean updated = false;
            for (int i = 0; i < row; i++) {
                char c = board[i][j];
                if((c >= '1' && c <= '9') && ranks[c - '0'] == 0){
                    ranks[c - '0'] = rank;
                    updated = true;
                }
            }

            rank += updated ? 1 : 0;
        }
        for (int i = 1; i < ranks.length; i++) {
            System.out.println(ranks[i]);
        }
    }
}