import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int r = Integer.parseInt(split[2]);

        int[] items = new int[n + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(split[i - 1]);
        }

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(i != j) graph[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            split = br.readLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);
            graph[v1][v2] = d;
            graph[v2][v1] = d;
        }
        // 플로이드 와샬 알고리즘
        for(int v = 1; v <= n; v++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(graph[i][v] + graph[v][j] < graph[i][j]){
                        graph[i][j] = graph[i][v] + graph[v][j];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int s = 1; s <= n; s++) {
            int sum = 0;
            for (int e = 1; e <= n; e++) {
                if(graph[s][e] <= m){
                    sum += items[e];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}