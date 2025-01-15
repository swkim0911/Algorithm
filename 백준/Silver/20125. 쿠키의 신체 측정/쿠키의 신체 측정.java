import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n+1][n+1];
        int x = 0; // 심장 위치
        int y = 0; // 심장 위치
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                board[i][j] = split[j-1];
                if(!flag && board[i][j].equals("*")){
                    flag = true;
                    x = i + 1;
                    y = j;
                }
            }
        }
        sb.append(x + " " + y).append("\n");
        int leftHandLength = getLeftHandLength(board, n, x, y);
        int rightHandLength = getRightHandLength(board, n, x, y);
        int bodyLength = getBodyLength(board, n, x, y);
        int leftLegLength = getLeftLegLength(board, n, x, y);
        int rightLegLength = getRightLegLength(board, n, x, y);
        sb.append(leftHandLength).append(" ");
        sb.append(rightHandLength).append(" ");
        sb.append(bodyLength).append(" ");
        sb.append(leftLegLength).append(" ");
        sb.append(rightLegLength);
        System.out.print(sb);


    }

    private static int getLeftLegLength(String[][] board, int n, int x, int y) {
        int length = 0;
        for (int i = x + 1; i <= n; i++) {
            if (board[i][y-1].equals("*")) {
                length++;
            }
        }
        return length;
    }

    public static int getRightLegLength(String[][] board, int n, int x, int y) {
        int length = 0;
        for (int i = x + 1; i <= n; i++) {
            if (board[i][y+1].equals("*")) {
                length++;
            }
        }
        return length;
    }


    private static int getBodyLength(String[][] board, int n, int x, int y) {
        int length = 0;
        for (int i = x + 1; i <= n; i++) {
            if (!board[i][y].equals("*")) {
                break;
            }
            length++;
        }
        return length;
    }

    public static int getLeftHandLength(String[][] board, int n, int x, int y){
        int length = 0;
        for (int i = 1; i < y; i++) {
            if (board[x][i].equals("*")) {
                length = y - i;
                break;
            }
        }
        return length;
    }

    public static int getRightHandLength(String[][] board, int n, int x, int y){
        int length = 0;
        for (int i = y + 1; i <= n; i++) {
            if (!board[x][i].equals("*")) {
                break;
            }
            length++;
        }
        return length;
    }

    public static void print(String[][] board){
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

// 심장은 머리 좌표 + (1,0)
