import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final int INF = Integer.MAX_VALUE / 2;
    static int n;
    static int[][] board, dp;
    static int start = 0; // 시작 노드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][(1<<n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = dfs(start, 1); // 노드 0에서 시작
        System.out.println(answer);
    }

    /**
     * @param cur 현재 노드
     * @param visited 현재 노드를 포함한 방문 노드들의 비트마스크
     * @return 최소 비용
     */
    public static int dfs(int cur, int visited){
        if(visited == (1 << n) - 1){ // visited == 11111(2). 모든 노드를 방문한 경우
            if(board[cur][start] != 0) return board[cur][start];
            return INF;
        }

        if(dp[cur][visited] != -1) return dp[cur][visited]; // 방문 이력이 있는 경우
        dp[cur][visited] = INF;
        for (int i = 0; i < n; i++) {
            // i 노드를 방문하지 않았고 cur -> i 경로가 있는 경우
            if(board[cur][i] != 0 && (visited & (1 << i)) == 0){
                dp[cur][visited] = Math.min(dp[cur][visited], dfs(i, visited | (1 << i)) + board[cur][i]);
            }
        }
        return dp[cur][visited];
    }
}