import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[]  visited;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        visited = new boolean[n];
        dfs(0, "");
        System.out.print(sb);
    }

    public static void dfs(int cur, String str){
        if(cur == m){
            sb.append(str.trim()).append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(visited[i-1]) continue;
            visited[i-1] = true;
            dfs(cur + 1, str + i +" ");
            visited[i-1] = false;
        }
    }
}
