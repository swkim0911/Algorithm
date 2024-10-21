import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Edge> graph = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            graph.add(new Edge(i + 1, n + 1, val));
        }
        
        for(int i = 1; i <= n; i++){
            String[] split = br.readLine().split(" ");
            for(int j = i+1; j <= n ; j++){
                graph.add(new Edge(i, j, Integer.parseInt(split[j-1])));
            }
        }

        n++; // 가상의 정점 때문에 추가
        int[] parent = new int[n+1]; // parent[x]: 정점 x의 부모 노드
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        graph.sort((o1, o2) -> o1.val - o2.val);

        int answer = 0;
        int cnt = 0;
        for(Edge edge : graph){
            if(isDiffGroup(parent, edge.a, edge. b)){
                union(parent, edge.a, edge.b);
                answer += edge.val;
                cnt++;
            }

            if(cnt == n-1) break;
        }
        System.out.print(answer);
    }

    // 두 정점 a,b 가 서로 다른 집합에 있는지 확인
    public static boolean isDiffGroup(int[] parent, int a, int b){
        int v1 = getParent(parent, a);
        int v2 = getParent(parent, b);
        return v1!=v2;
    }

    // 정점 v의 부모 정점 찾기
    public static int getParent(int[] parent, int v){
        if(parent[v] == v) return v;
        return parent[v] = getParent(parent, parent[v]); // 최적화
    }

    // 정점 a와 b를 같은 집합으로 합침
    public static void union(int[] parent, int a, int b){
        int v1 = getParent(parent, a);
        int v2 = getParent(parent, b);
        if(v1 < v2) parent[v2] = v1;
        else parent[v1] = v2;
    }

    /**
     * 1. 크루스칼 알고리즘을 사용하기 위해 주어진 그래프를 모델링(확장) 하기
     * - 다른 가상의 정점을 추가해서 그 정점으로 가는 간선의 가중치를 접 논을 파는 비용이라고 생각한다.
     * - 어떤 정점이든 무조건 가상의 정점에 가거나 다른 정점과 간선을 연결해야 하는데 그럼 자연스럽게 하나의 트리가 완성된다.
     */
}

class Edge{
    int a;
    int b;
    int val;

    public Edge(int a, int b, int val){
        this.a = a;
        this.b = b;
        this.val = val;
    }
}
