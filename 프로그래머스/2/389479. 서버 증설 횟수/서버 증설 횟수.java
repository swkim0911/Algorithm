import java.util.*;


class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int cur = 0; // 증설된 서버 수
        Queue<Integer> q = new LinkedList<>();
        for(int player : players){
            int qSize = q.size();
            for(int j = 0; j < qSize; j++){ // 시간 지남에 따라 갱신
                int head = q.poll();
                q.add(head - 1);
            }
            
            while(!q.isEmpty() && q.peek() == 0){
                q.poll();
                cur -= 1;         
            }
            if(player / m > 0){
                int haveTo = player / m;
                if(haveTo > cur){
                    answer += (haveTo - cur);
                    for(int j = 0; j < haveTo - cur; j++){
                        q.add(k);
                    }
                    cur = haveTo;
                }
            }
            // System.out.println(player+", "+cur+", "+answer);
            
        }
        
        return answer;
    }
}