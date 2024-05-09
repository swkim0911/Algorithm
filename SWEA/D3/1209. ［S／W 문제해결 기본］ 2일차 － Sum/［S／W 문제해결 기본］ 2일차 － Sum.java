import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static final int LENGTH = 100;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 10;
        while (testcase-- > 0) {
            int t = Integer.parseInt(br.readLine());
            int[][] board = new int[100][100];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < LENGTH; i++) {
                String[] split = br.readLine().split(" ");
                int sum = 0;
                for (int j = 0; j < LENGTH; j++) {
                    board[i][j] = Integer.parseInt(split[j]);
                    sum += board[i][j]; // 가로
                }
                max = Math.max(max, sum);
            }
            // 세로
            for (int i = 0; i < LENGTH; i++) {
                int sum = 0;
                for (int j = 0; j < LENGTH; j++) {
                    sum += board[j][i];
                }
                max = Math.max(max, sum);
            }
            int i = 0;
            int j = 0;
            int sum = 0;
            while (i < 100 && j < 100) { // \ sum
                sum += board[i][j];
                i++;
                j++;
            }
            max = Math.max(max, sum);
            i = 0;
            j = 99;
            sum = 0;
            while (i < 100 && j >= 0) { // / sum
                sum += board[i][j];
                i++;
                j--;
            }
            max = Math.max(max, sum);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}