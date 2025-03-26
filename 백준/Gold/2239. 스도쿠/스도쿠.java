import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static final int N = 9;
    static int[][] board;
    static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                if(board[i][j] == 0) list.add(new Pair(i, j));
            }
        }
        dfs(0);
        print();
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean dfs(int cnt) {
        if (cnt == list.size()) {
            return true;
        }
        int x = list.get(cnt).x;
        int y = list.get(cnt).y;
        for (int i = 1; i < 10; i++) {
            board[x][y] = i;
            if(isOk(x,y) && dfs(cnt + 1)) return true;
        }
        board[x][y] = 0;
        return false;
    }

    public static boolean isOk(int x,int y){
        for (int i = 0; i < N; i++) {
            if(x != i && board[i][y] == board[x][y]) return false;
            if(y != i && board[x][i] == board[x][y]) return false;
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(i != x && j != y && board[i][j] == board[x][y]) return false;
            }
        }

        return true;
    }
}

class Pair{
    int x,y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}