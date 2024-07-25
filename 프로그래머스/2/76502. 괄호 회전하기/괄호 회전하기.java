import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            // 확인
            if(isRight(s)) answer++;
            // 회전
            s = rotate(s);
        }
        return answer;
    }
    
    public boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top != '(') return false; 
            }else if(c == ']'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top != '[') return false; 
            }else if(c == '}'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top != '{') return false; 
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
    
    public String rotate(String s){
        return s.substring(1) + s.charAt(0);
    }
}

// i = 0;