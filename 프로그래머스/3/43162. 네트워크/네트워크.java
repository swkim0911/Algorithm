import java.util.*;

class Solution {
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            bfs(i, computers, visited, n);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int node, int[][] computers, boolean[] visited, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i = 0; i < n; i++){
                if(cur == i || visited[i]) continue; // 이미 방문했거나 노드가 자기자신일 때
                if(computers[cur][i] == 1){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}