import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>(); // 삭제시 저장 자료구조
        int size = n;
        
        for(String cmd : cmds){
            String[] split = cmd.split(" ");
            if(split[0].equals("U")){
                k -= Integer.parseInt(split[1]);
            }else if(split[0].equals("D")){
                k += Integer.parseInt(split[1]);
            }else if(split[0].equals("C")){
                stack.add(k);
                size--;
                if(k == size){
                    k--;
                }
            }else if(split[0].equals("Z")){
                if(stack.pop() <= k){ // 현재 위치 위에 넣으면 k가 하나 뒤로감
                    k++;
                }
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



