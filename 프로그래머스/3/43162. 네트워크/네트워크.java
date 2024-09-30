import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList[n];
        isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
            
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    // bfs
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : graph[cur]){
                if(isVisited[nxt]) continue;
                q.add(nxt);
                isVisited[nxt] = true;
            }
        }
    }
}