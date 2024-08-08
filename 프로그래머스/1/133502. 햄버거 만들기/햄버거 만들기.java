import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : ingredient){
            stack.push(i);
            if(stack.size() >= 4){
                String tmp = "";
                for(int j = 0; j < 4; j++){
                    tmp += stack.pop();
                }
                if(tmp.equals("1321")) answer++;
                else{
                    for(int j = 3; j >= 0; j--){
                        stack.push(tmp.charAt(j) - '0');
                    }
                }
            }
        }
        return answer;
    }
}

