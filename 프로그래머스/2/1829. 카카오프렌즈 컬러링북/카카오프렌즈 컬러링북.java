import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    int numberOfArea = 0;
    int maxSizeOfOneArea = Integer.MIN_VALUE;
    
    public int[] solution(int m, int n, int[][] picture) {        
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){ // 색이 있고 방문한 경우
                    bfs(m,n, new Pair(i,j), picture);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
            
        return answer;
    }
    
    public void bfs(int m, int n, Pair pair, int[][] picture){
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        visited[pair.x][pair.y] = true;
        int color = picture[pair.x][pair.y];
        int cnt = 1;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny] || picture[nx][ny] != color) continue;
                q.add(new Pair(nx,ny));
                cnt++;
                visited[nx][ny] = true;
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}

class Pair{
    int x,y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

/**
1 1 1 0
1 2 2 0
1 0 0 1
0 0 0 1
0 0 0 3
0 0 0 3

*/
