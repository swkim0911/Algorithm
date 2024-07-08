import java.util.*;

class Solution {
    
    List<Integer>[] graph = new ArrayList[20_001];
    int[] visited = new int[20_001];
    int max = Integer.MIN_VALUE;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs();
        for(int i = 1; i < visited.length; i++){
            if(max == visited[i]) answer++;
        }
        return answer;
    }
    
    public void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 시작
        visited[1] = 1;
        while(!q.isEmpty()){
            Integer cur = q.poll();
            if(max < visited[cur]) max = visited[cur];
            for(int nxt : graph[cur]){
                if(visited[nxt] > 0) continue; // 방문한 경우
                visited[nxt] = visited[cur] + 1;
                q.add(nxt);
            }
        }
    }
}
// bfs