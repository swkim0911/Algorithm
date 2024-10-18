import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        dfs(0, n, "");
        System.out.print(sb);
    }

    public static void dfs(int cur, int n, String str){
        if(cur == n){
            sb.append(str.trim()).append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i-1]) continue;
            visited[i-1] = true;
            dfs(cur + 1, n, str+i+" ");
            visited[i-1] = false;
        }
    }
}