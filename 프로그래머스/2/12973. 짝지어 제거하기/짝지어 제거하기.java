import java.util.*;

class Solution
{
    public int solution(String s){
       
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < charArr.length; i++){
            char c = charArr[i];
            if(stack.isEmpty()) stack.push(c);
            else{
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
    
}