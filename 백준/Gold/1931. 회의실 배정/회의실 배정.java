import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Data(s, e));
        }
        list.sort((o1,o2) -> {
            if(o1.e == o2.e) {
                return o1.s - o2.s;
            }
            return o1.e - o2.e;
        });
        int end = 0;
        int answer = 0;
        for (Data data : list) {
            if(end <= data.s){
                end = data.e;
                answer += 1;
            }

        }
        // 최대 사용할 수 있는 회의의 최대 개수 r 빨리 끝나는 것 먼저
        // 1-4, 5-7, 8-11, 12-14
        System.out.println(answer);

    }

    static class Data{
        int s;
        int e;

        public Data(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}