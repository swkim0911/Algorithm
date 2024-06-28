class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < section.length; i++){
            visited[section[i]] = true;
        }
        
        for(int i = 0; i < section.length; i++){
            if(visited[section[i]]){
                answer++;
                for(int j = section[i]; j < section[i] + m; j++){
                    if(j <= n && visited[j]) visited[j] = false;
                }
            }
        }
        
        return answer;
    }
}