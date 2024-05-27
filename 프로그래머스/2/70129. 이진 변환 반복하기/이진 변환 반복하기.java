import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCnt = 0;
        while(true){
            if(s.equals("1")) break;
            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();
            zeroCnt += before - after;
            String tmp = "";
            while(after != 0){ // 이진수 전환
                int rest = after % 2;
                tmp = String.valueOf(rest) + tmp;
                after /= 2;
            }
            s = tmp;
            count++;
        }
        int[] answer = {count, zeroCnt};
        return answer;
    }
}