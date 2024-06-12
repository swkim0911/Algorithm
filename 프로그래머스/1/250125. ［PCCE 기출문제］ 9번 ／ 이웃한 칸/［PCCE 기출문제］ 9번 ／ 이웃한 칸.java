class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int answer = 0;
        String color = board[h][w];
        for(int i = 0; i < 4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(board[nx][ny].equals(color)) answer++;
        }
        return answer;
    }
}