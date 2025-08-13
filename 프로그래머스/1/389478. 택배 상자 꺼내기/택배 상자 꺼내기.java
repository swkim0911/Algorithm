import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        ArrayList<int[]> board = new ArrayList<>();
        int t = 0;
        int box = 1;
        while(n != 0){
            int[] row = new int[w];
            for(int i = 0; i < (w < n ? w : n); i++){
                row[i] = box++;
            }
            if(t % 2 != 0){ // 뒤집기
                for(int i = 0; i < row.length / 2; i++){
                    int tmp = row[i];
                    row[i] = row[row.length - i - 1];
                    row[row.length - i - 1] = tmp;
                }
            }
            
            board.add(row);
            n = w < n ? n-w : 0;
            t += 1;
        }
        int answer = 0;
        
        int col = -1;
        
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < w; j++){
                if(board.get(i)[j] == num){
                    col = j;
                }
                if(col != -1 && j == col && board.get(i)[j] != 0){
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}

// 1 2 3 4 5
// 5 4 3 2 1

/**
1 2 3
6 5 4
7 8 9
12 11 10
13
**/