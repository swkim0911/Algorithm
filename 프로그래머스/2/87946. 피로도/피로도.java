import java.util.*;

class Solution {
    
    int answer = Integer.MIN_VALUE;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, new ArrayList<>(), dungeons);
        return answer;
    }
    
    public void dfs(int k, List<Integer> list, int[][]dungeons){
        // 종료 조건
        if(list.size() == dungeons.length){
            for(int i = 0; i < list.size(); i++){
                if(k < dungeons[list.get(i)][0]){
                    answer = Math.max(answer, i);
                    return;
                }
                k -= dungeons[list.get(i)][1];
            }
            answer = Math.max(answer, list.size());
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(i);
            dfs(k, tmp, dungeons);
            visited[i] = false;
        }
    }
}

// 부르트포스: 8! 