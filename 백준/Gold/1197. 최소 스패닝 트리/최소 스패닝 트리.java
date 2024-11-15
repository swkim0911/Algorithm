import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int v = Integer.parseInt(split[0]);
        int e = Integer.parseInt(split[1]);
        PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w); // weight 기준으로 오름차순

        for (int i = 0; i < e; i++) {
            split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);
            pq.add(new Data(start, end, weight));
        }
        
        int[] arr = new int[v + 1]; // arr[x]: 정점 x의 부모. 자기 자신이 부모이면 Root
        for(int i = 1; i <= v; i++){
            arr[i] = i;
        }

        int answer = 0;
        int cnt = 0;
        // 크루스칼 알고리즘
        // 1. weight 가 작은 것들을 먼저 뽑기.
        // 2. 뽑았을 때 두 정점이 같은 그룹이 아니면 포함
        while(cnt != v-1){
            Data data = pq.poll();
            if(!isGroup(data.s, data.e, arr)){
                cnt++;
                union(data.s, data.e, arr);
                answer += data.w;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroup(int v1, int v2, int[] arr){
        int p1 = getParent(v1, arr);
        int p2 = getParent(v2, arr);
        return p1 == p2; // 부모가 같으면 같은 그룹
    }

    public static int getParent(int v, int[] arr){
        if(arr[v] == v) return v;
        return arr[v] = getParent(arr[v], arr);
    }

    public static void union(int v1, int v2, int[] arr){
        int p1 = getParent(v1, arr);
        int p2 = getParent(v2, arr);
        if(p1 < p2) arr[p2] = p1;
        else arr[p1] = p2;
    }


}

class Data{
    int s;
    int e;
    int w;

    public Data(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
}