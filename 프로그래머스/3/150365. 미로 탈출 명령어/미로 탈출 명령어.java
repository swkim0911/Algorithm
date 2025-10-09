import java.util.*;

class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] dirs = {"d", "l", "r", "u"};
    String answer = "impossible";
    boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if (dist > k || (dist % 2 != k % 2)) return "impossible";

        dfs(n, m, x, y, r, c, k, 0, new StringBuilder());
        return answer;
    }

    void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, StringBuilder sb) {
        if (found) return;
        if (depth == k) {
            if (x == r && y == c) {
                answer = sb.toString();
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            int remain = k - depth - 1;
            int dist = Math.abs(r - nx) + Math.abs(c - ny);
            if (dist > remain) continue;
            if ((dist % 2) != (remain % 2)) continue;

            sb.append(dirs[i]);
            dfs(n, m, nx, ny, r, c, k, depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
