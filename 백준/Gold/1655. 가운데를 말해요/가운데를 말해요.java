import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lessPQ = new PriorityQueue<>((o1,o2) -> o2-o1); // mid 보다 작은 것들
        PriorityQueue<Integer> morePQ = new PriorityQueue<>((o1,o2) -> o1-o2); // mid 보다 큰 것들

        int mid = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(i == 0){
                mid = val;
            }else {
                if (mid < val) {
                    morePQ.add(val);
                    if (morePQ.size() - lessPQ.size() > 1) {
                        lessPQ.add(mid);
                        mid = morePQ.poll();
                    }

                } else {
                    lessPQ.add(val);
                    if (lessPQ.size() - morePQ.size() > 0) {
                        morePQ.add(mid);
                        mid = lessPQ.poll();
                    }
                }
            }
            sb.append(mid).append("\n");
        }
        System.out.println(sb);
    }
}
