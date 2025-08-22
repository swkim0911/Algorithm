import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Data{
    int number;
    int deadLine;
    int ramens;

    public Data(int number, int deadLine, int ramens) {
        this.number = number;
        this.deadLine = deadLine;
        this.ramens = ramens;
    }

    @Override
    public String toString() {
        return "Data{" +
                "number=" + number +
                ", deadLine=" + deadLine +
                ", ramens=" + ramens +
                '}';
    }
}
public class Main{

    static int n;
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) ->  o2.ramens - o1.ramens);
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static int sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new Data(i + 1, d, r));
            treeSet.add(i + 1);
        }
        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            // 데드라인과 가깝게 두기. logn으로 찾아야 한다.
            Integer floor = treeSet.floor(cur.deadLine);
//            System.out.println(cur);
//            System.out.println("floor = " + floor);
            if (floor != null) {
                treeSet.remove(floor);
                sum += cur.ramens;
            }
        }

        System.out.println(sum);
    }

}
