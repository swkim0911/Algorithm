import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 6; i++){
            set.add(win_nums[i]);
        }
        int cnt = 0;
        int zero = 0;
        for(int i = 0; i < 6; i++){
            if(set.contains(lottos[i])) cnt++;
            if(lottos[i] == 0) zero++;
        }
        
        int[] answer = new int[2];
        int max = cnt + zero;
        int min = cnt;
        answer[0] = max >= 2 ? 7 - max : 6;
        answer[1] = min >= 2 ? 7 - min : 6;
        return answer;
    }
}