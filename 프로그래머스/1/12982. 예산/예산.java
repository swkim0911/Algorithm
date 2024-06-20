import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int demand : d){
            if(budget - demand >= 0){
                answer++;
                budget -= demand;
            }else break;
        }
        return answer;
    }
}