import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static int n;
    static int[][] board;
    static int cnt;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            cnt = 0;
            dfs(n, 0);
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n, int cur) {
        if (n == cur) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check1(cur, i) && check2(cur, i) && check3(cur, i)) {
                board[cur][i] = 1;
                dfs(n, cur + 1);
                board[cur][i] = 0;
            }
        }
    }

    //세로에 퀸이 있는지
    static boolean check1(int x, int y) {
        for (int r = 0; r < x; r++) {
            if(board[r][y] == 1) return false;
        }
        return true;
    }

    // \ 방향에 퀸이 있는지
    static boolean check2(int x, int y) {
        int nx = x-1;
        int ny = y-1;
        while(nx >= 0 && nx < n && ny >= 0 && ny < n){
            if(board[nx][ny] == 1) return false;
            nx -= 1;
            ny -= 1;
        }
        return true;
    }

    // / 방향에 퀸이 있는지
    static boolean check3(int x, int y) {
        int nx = x-1;
        int ny = y+1;
        while(nx >= 0 && nx < n && ny >= 0 && ny < n){
            if(board[nx][ny] == 1) return false;
            nx -= 1;
            ny += 1;
        }
        return true;
    }
}