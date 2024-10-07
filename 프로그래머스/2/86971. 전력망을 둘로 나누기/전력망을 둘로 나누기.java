import java.util.*;

class Solution {
    
    int[][] tree;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        tree = new int[n+1][n+1];
        
        // 초기화
        for(int[] wire : wires){
            tree[wire[0]][wire[1]] = 1;
            tree[wire[1]][wire[0]] = 1;
        }
        
        for(int[] wire : wires){
            tree[wire[0]][wire[1]] = 0;
            tree[wire[1]][wire[0]] = 0;
            visited = new boolean[n+1];
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                if(visited[i]) continue;
                int cnt = bfs(i,n);
                list.add(cnt);
            }
            answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
            
            tree[wire[0]][wire[1]] = 1;
            tree[wire[1]][wire[0]] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int node, int n){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for(int i = 1; i <= n; i++){
                if(tree[cur][i] == 0 || visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        return cnt;
    }
}