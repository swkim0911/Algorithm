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

        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int remain = max - min;
        long answer = min * (long) Math.min(2*w, s);
        answer += ((remain / 2) * 2) * (long) Math.min(w,s);
        if(remain % 2 == 1){
            answer += w;
        }
        System.out.println(answer);
    }
}