import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>();  // 삭제된 행 번호
        for(String cmd : cmds){
            char c = cmd.charAt(0);
            if(c == 'U'){
                k -= Integer.parseInt(cmd.substring(2));
            }else if(c == 'D'){
                k += Integer.parseInt(cmd.substring(2));
            }else if(c == 'C'){
                if(stack.push(k) == n - 1){ // 현재 위치가 바닥에 있는 경우
                    k--;
                }
                n--;
            }else if(c == 'Z'){
                n++;
                if(stack.pop() <= k){ // 현재 위치 위에 복구되는 경우 현재 선택된 행 번호가 바꾼다.
                    k++;   
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("O");
        }
        while(!stack.isEmpty()){
            sb.insert(stack.pop().intValue(), "X");
        }
        
        return sb.toString();
    }
}

// 삽입 삭제가 O(1) -> linkedlist 인데
// 그 위치까지 찾아가려면 O(n) 이 걸려서 그럼 배열 인덱스로 정보에 접근해야 하는 데 이 두 기능을 하는 자료구조는 없고. 또 그럼 배열,linkedlist 두 개를 써서 어떻게 해보려 했는데 방법이 없다.

