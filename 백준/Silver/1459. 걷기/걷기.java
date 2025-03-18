import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int w = Integer.parseInt(split[2]);
        int s = Integer.parseInt(split[3]);
        long answer = 0;
        while(x >= 1 && y >= 1) {
            if (2 * w < s) {
                answer += 2 * w;
            } else {
                answer += s;
            }
            x--;
            y--;
        }
        while(x >= 2) {
            answer += Math.min(2 * w, 2 * s);
            x -= 2;
        }
        while(y >= 2) {
            answer += Math.min(2 * w, 2 * s);
            y -= 2;
        }
        if (x == 1) {
            answer += w;
        }
        if (y == 1) {
            answer += w;
        }
        System.out.println(answer);
    }
}

