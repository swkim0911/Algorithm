import java.util.*;

class Solution {
    
    PriorityQueue<String> pq = new PriorityQueue<>();
    boolean[] isUsed;
    
    public String[] solution(String[][] tickets) {
        isUsed = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        return pq.poll().split(" ");
    }
    
    public void dfs(int cnt, String cur, String course, String[][] tickets){
        if(cnt == tickets.length){
            pq.add(course);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            
            if(!isUsed[i] && cur.equals(tickets[i][0])){
                isUsed[i] = true;
                dfs(cnt + 1, tickets[i][1], course +" " + tickets[i][1], tickets);
                isUsed[i] = false;
            }
        }
    }
}