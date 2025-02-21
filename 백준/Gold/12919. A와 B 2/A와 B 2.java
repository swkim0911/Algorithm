import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int answer = bfs(s, t);
        System.out.println(answer);
    }

    public static int bfs(String s, String t) {
        Queue<String> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if(cur.equals(s)) return 1;
            if(cur.endsWith("A")){
                q.add(cur.substring(0, cur.length() - 1));
            }
            if(cur.startsWith("B")){
                q.add(new StringBuilder(cur.substring(1)).reverse().toString());
            }
        }
        return 0;
    }
}