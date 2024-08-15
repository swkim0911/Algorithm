class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n+1][m+1]; // 행렬 내 각 건물이 받는 공격, 회복에 총합(누적합으로 계산)
        for(int[] s : skill){
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += (degree * -1);
            sum[r2 + 1][c1] += (degree * -1);
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        
        // 누적합 계산
        for(int r = 0; r < n + 1; r++){
            for(int l = 0; l < m; l++){
                sum[r][l+1] += sum[r][l];
            }
        }
        for(int l = 0; l < m + 1; l++){
            for(int r = 0; r < n; r++){
                sum[r+1][l] += sum[r][l];
            }
        }
        
        
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}

// brute force 시간: 250.000 * (1,000,000) + 1,000,000 (확인 시간)

