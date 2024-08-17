import java.util.*;

class Solution {
    boolean[] isVisited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(isVisited[i]) continue;
            bfs(i, n, computers);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int start, int n, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        while(!q.isEmpty()){
            Integer cur = q.poll();
            for(int i = 0; i < n; i++){
                if(i == cur || isVisited[i]) continue;
                if(computers[cur][i] == 1){
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}

// bfs