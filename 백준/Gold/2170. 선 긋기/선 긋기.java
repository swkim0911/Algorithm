import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x, y));
        }

        Collections.sort(lines, (o1, o2) -> {
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        int min = lines.get(0).x;
        int max = lines.get(0).y;
        int len = max - min;

        for (int i = 1; i < n; i++) {
            Line line = lines.get(i);
            if(min <= line.x && line.y <= max) continue;
            else if(line.x < max){
                len += line.y - max;
            }else{
                len += line.y - line.x;
            }
            min = line.x;
            max = line.y;
        }

        System.out.println(len);



    }

    static class Line {
        int x,y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}