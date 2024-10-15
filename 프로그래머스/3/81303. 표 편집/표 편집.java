import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for(String cmd : cmds){
            char c = cmd.charAt(0);
            if(c == 'U'){
                k -= Integer.parseInt(cmd.substring(2));
            }else if(c == 'D'){
                k += Integer.parseInt(cmd.substring(2));
            }else if(c == 'C'){
                stack.add(k);
                if(k == size - 1){
                    k--;
                }
                size--;
            }else if(c == 'Z'){
                if(stack.pop() <= k){
                    k++;
                };
                size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append("O");
        }
        while(!stack.isEmpty()){
            sb.insert(stack.pop().intValue(), "X");
        }
        return sb.toString();
    }
}