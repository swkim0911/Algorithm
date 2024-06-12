import java.util.*;

class Solution {
    
    ArrayList<Integer>[] adj;
    int[] visited;
    int depth = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        adj = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        bfs();
        
        for(int i = 1; i <= n; i++){
            if(depth == visited[i]) answer++;
        }
        
        return answer;
    }
    
    public void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        
        while(!q.isEmpty()){
            Integer cur = q.poll();
            if(depth < visited[cur]) depth = visited[cur];
            
            for(int i = 0; i < adj[cur].size(); i++){
                Integer nxt = adj[cur].get(i);
                if(visited[nxt] != 0) continue;
                visited[nxt] = visited[cur]+1;
                q.add(nxt);
            }
        }
    }
    
}