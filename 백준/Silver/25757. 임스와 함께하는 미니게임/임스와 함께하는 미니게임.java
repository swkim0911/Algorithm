import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        String game = split[1];
        int total = 0;
        if(game.equals("Y")){
            total = 2;
        }else if(game.equals("F")){
            total = 3;
        } else if (game.equals("O")) {
            total = 4;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int answer = set.size() / (total - 1);
        System.out.println(answer);
    }
}