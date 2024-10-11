import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }
        // 0 1 2 4
        // answer[3] = 1;
        while(!stack.isEmpty()){
            answer[stack.peek()] = n - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}
// 3 2
// 부르트포스를 피하기 위해 stack 사용
