import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows+1][columns+1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                board[i][j] = columns*(i-1) + j;
            }
        }
        int[] answer = new int[queries.length];
        int t = 0;
        for(int[] query : queries){
            int startX = query[0];
            int startY = query[1];
            int endX = query[2];
            int endY = query[3];
            
            int start = board[startX][startY];
            int min = start;
            // 왼족 세로
            for(int r = startX+1; r <= endX; r++){
                board[r-1][startY] = board[r][startY];
                min = Math.min(min, board[r][startY]);
            }
            // 아래 가로
            for(int c = startY+1; c <= endY; c++){
                board[endX][c-1] = board[endX][c];
                min = Math.min(min, board[endX][c]);
            }
            // 오른 세로
            for(int r = endX-1; r >= startX; r--){
                board[r+1][endY] = board[r][endY];
                min = Math.min(min, board[r][endY]);
            }
            // 위 가로
            for(int c = endY-1; c > startY; c--){
                board[startX][c+1] = board[startX][c];
                min = Math.min(min, board[startX][c]);
            }
            board[startX][startY+1] = start;
            answer[t++] = min;
        }
        
        return answer;
    }
}

/**
8 기억. 14 20 26 
*/