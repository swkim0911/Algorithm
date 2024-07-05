import java.util.*;

class Solution {
    // 상,좌,하,우
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    int n;
    
    public int solution(int[][] board) {
        n = board.length;
        return Math.min(bfs(board, new Car(0,0,0,2)), bfs(board, new Car(0,0,0,3)));
    }
    
    public int bfs(int[][] board, Car car){
        int[][] costBoard = new int[n][n];
        
        Queue<Car> q = new LinkedList<>();
        q.add(car);
        while(!q.isEmpty()){
            Car cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[nx][ny] == 1) continue;
                int newCost = (cur.dir == i) ? cur.cost + 100 : cur.cost + 600;
                if(costBoard[nx][ny] == 0 || (costBoard[nx][ny] != 0 && costBoard[nx][ny] > newCost)){
                    q.add(new Car(nx,ny, newCost, i));
                    costBoard[nx][ny] = newCost;
                }
            }
        }
        return costBoard[n-1][n-1];
    }
}
class Car{
    int x,y,cost,dir;
    
    public Car(int x, int y, int cost, int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}