import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = 0;
        int success = 0;
        int idx = 0;
        for(int t = 1; t <= attacks[attacks.length-1][0]; t++){
            if(t == attacks[idx][0]){
                success = 0;
                answer -= attacks[idx][1]; // 공격
                if(answer <= 0) return -1;
                idx++;
            }else{
                success++;
                answer =  answer + bandage[1] > health ? health : answer + bandage[1]; // 체력 변화
                if(success == bandage[0]){
                    success = 0;
                    answer =  answer + bandage[2] > health ? health : answer + bandage[2];
                }
            }
        }
        
        return answer;
    }
    
    
    
}